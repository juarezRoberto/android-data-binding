package com.juarez.android.databinding.navigation.thirdgraph

import android.os.Bundle
import android.view.View
import androidx.navigation.findNavController
import androidx.navigation.navGraphViewModels
import com.juarez.android.databinding.R
import com.juarez.android.databinding.databinding.FragmentFifthBinding
import com.juarez.android.databinding.utils.BaseFragment


class FifthFragment : BaseFragment<FragmentFifthBinding>(R.layout.fragment_fifth) {

    private val viewModel: NavGraphViewModel by navGraphViewModels(R.id.third_nav_graph)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFifthOpenSixthFragment.setOnClickListener {
            val action = FifthFragmentDirections.actionFifthFragmentToSixthFragment()
            it.findNavController().navigate(action)
        }

        binding.btnFifthIncrement.setOnClickListener {
            viewModel.increment()
        }

        viewModel.value.observe(viewLifecycleOwner) { newValue ->
            binding.txtFifthValue.text = "$newValue"
        }
    }
}