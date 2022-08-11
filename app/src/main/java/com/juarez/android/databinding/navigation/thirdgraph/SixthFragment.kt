package com.juarez.android.databinding.navigation.thirdgraph

import android.os.Bundle
import android.view.View
import androidx.navigation.navGraphViewModels
import com.juarez.android.databinding.R
import com.juarez.android.databinding.databinding.FragmentSixthBinding
import com.juarez.android.databinding.utils.BaseFragment


class SixthFragment : BaseFragment<FragmentSixthBinding>(R.layout.fragment_sixth) {

    private val viewModel: NavGraphViewModel by navGraphViewModels(R.id.third_nav_graph)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.value.observe(viewLifecycleOwner) { newValue ->
            binding.txtSixthValue.text = "$newValue"
        }
    }

}