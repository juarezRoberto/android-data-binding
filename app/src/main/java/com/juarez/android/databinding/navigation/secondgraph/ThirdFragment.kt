package com.juarez.android.databinding.navigation.secondgraph

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.juarez.android.databinding.R
import com.juarez.android.databinding.databinding.FragmentThirdBinding
import com.juarez.android.databinding.utils.BaseFragment

class ThirdFragment : BaseFragment<FragmentThirdBinding>(R.layout.fragment_third) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnThirdOpenFourthFragment.setOnClickListener {
            val action = ThirdFragmentDirections.actionThirdFragmentToFourthFragment()
            it.findNavController().navigate(action)
        }
    }
}