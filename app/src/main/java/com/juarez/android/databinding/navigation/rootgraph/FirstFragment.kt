package com.juarez.android.databinding.navigation.rootgraph

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.juarez.android.databinding.R
import com.juarez.android.databinding.databinding.FragmentFirstBinding
import com.juarez.android.databinding.utils.BaseFragment


class FirstFragment : BaseFragment<FragmentFirstBinding>(R.layout.fragment_first) {

    private val viewModel: FirstViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnFirstIncrement.setOnClickListener {
            viewModel.increment()
        }

        viewModel.value.observe(viewLifecycleOwner) { newValue ->
            binding.txtFirstValue.text = "$newValue"
        }
    }
}