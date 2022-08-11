package com.juarez.android.databinding.navigation

import android.Manifest
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import com.juarez.android.databinding.R
import com.juarez.android.databinding.databinding.FragmentMainBinding
import com.juarez.android.databinding.notifications.Notification
import com.juarez.android.databinding.utils.BaseFragment
import com.juarez.android.databinding.utils.Downloader
import com.juarez.android.databinding.utils.PermissionResult
import com.juarez.android.databinding.utils.requestPermission
import java.io.File


class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {

    private var downloadId: Long = -1
    private lateinit var imagePath: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOpenNotification.setOnClickListener {
            Notification(
                requireContext(),
                bundleOf("foo" to "foo", "bar" to "bar")
            ).show()
        }

        binding.btnOpenFirstFragment.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToFirstFragment()
            it.findNavController().navigate(action)
        }

        binding.btnOpenSecondFragment.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToSecondFragment("foo", "bar")
            it.findNavController().navigate(action)
        }

        binding.btnMainOpenThirdNestedGraph.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToThirdNavGraph()
            it.findNavController().navigate(action)
        }

        binding.btnDownload.setOnClickListener {
            requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) {
                when (it) {
                    PermissionResult.GRANTED -> downloadImage()
                    PermissionResult.DENIED -> {
                        Toast.makeText(requireContext(), "Denegado", Toast.LENGTH_SHORT).show()
                        requestPermissionLauncher.launch(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    }
                    PermissionResult.RATIONALE -> Unit
                }
            }
        }
    }

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) downloadImage()
            else Toast.makeText(requireContext(), "Denegado again", Toast.LENGTH_SHORT).show()
        }

    private val broadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, intent: Intent?) {
            val id = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1) ?: -1
            if (downloadId == id) {
                Toast.makeText(requireContext(), "Descargado", Toast.LENGTH_SHORT).show()

                if (::imagePath.isInitialized) {
                    val path = getFile(imagePath)
                    if (path.isNotEmpty()) {
                        Toast.makeText(requireContext(), path, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun getFile(path: String): String {
        val file =
            File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
                path
            )

        if (file.exists()) return file.absolutePath
        return ""
    }

    private fun downloadImage() {
        Downloader.downloadFile(
            requireActivity(),
            "https://firebasestorage.googleapis.com/v0/b/zeusdev-cbbe5.appspot.com/o/580851%2FJPG20220802_123732_3576826719282946100.jpg?alt=media&token=3f6ef0a3-568e-448c-add5-ac4791a459c5"
        ) { id, path ->
            downloadId = id
            imagePath = path
        }
    }

    override fun onResume() {
        super.onResume()
        requireActivity().registerReceiver(
            broadcastReceiver,
            IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        )
    }

    override fun onStop() {
        super.onStop()
        requireActivity().unregisterReceiver(broadcastReceiver)
    }
}