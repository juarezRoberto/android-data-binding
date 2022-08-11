package com.juarez.android.databinding.navigation

import android.os.Bundle
import android.view.View
import com.juarez.android.databinding.R
import com.juarez.android.databinding.databinding.FragmentFirstBinding
import com.juarez.android.databinding.utils.BaseFragment


class FirstFragment : BaseFragment<FragmentFirstBinding>(R.layout.fragment_first) {
    
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}