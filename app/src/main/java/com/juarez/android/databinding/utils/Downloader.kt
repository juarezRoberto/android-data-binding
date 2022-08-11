package com.juarez.android.databinding.utils

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.fragment.app.FragmentActivity

object Downloader {

    fun downloadFile(
        activity: FragmentActivity,
        uri: String,
        onDownloading: (id: Long, path: String) -> Unit
    ) {
        val path = "${System.currentTimeMillis()}.png"
        val request = DownloadManager.Request(Uri.parse(uri))
            .setTitle("Zeus")
            .setDescription("descargando imagen...")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
            .setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI or DownloadManager.Request.NETWORK_MOBILE)
            .setAllowedOverRoaming(true)
            .setDestinationInExternalPublicDir(
                Environment.DIRECTORY_DOWNLOADS,
                path
            )

        val dm = (activity.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager)

        val downloadId = dm.enqueue(request)
        onDownloading(downloadId, path)
    }
}