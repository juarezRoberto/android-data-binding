package com.juarez.android.databinding.fragments

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import com.juarez.android.databinding.BaseFragment
import com.juarez.android.databinding.R
import com.juarez.android.databinding.databinding.FragmentThirdBinding

class ThirdFragment : BaseFragment<FragmentThirdBinding>(R.layout.fragment_third) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnOpenThirdNestedGraph.setOnClickListener {
            val action = ThirdFragmentDirections.actionThirdFragmentToThirdNavGraph()
            it.findNavController().navigate(action)
        }
    }

}