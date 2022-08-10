package com.juarez.android.databinding.fragments

import android.os.Bundle
import android.view.View
import com.juarez.android.databinding.BaseFragment
import com.juarez.android.databinding.R
import com.juarez.android.databinding.databinding.FragmentFirstBinding
import com.juarez.android.databinding.notifications.Notification

class FirstFragment : BaseFragment<FragmentFirstBinding>(R.layout.fragment_first) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOpenNotification.setOnClickListener {
            Notification(requireContext()).show()
        }
    }
}