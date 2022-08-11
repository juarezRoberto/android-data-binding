package com.juarez.android.databinding.navigation.rootgraph

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.juarez.android.databinding.R
import com.juarez.android.databinding.databinding.FragmentSecondBinding
import com.juarez.android.databinding.utils.BaseFragment

class SecondFragment : BaseFragment<FragmentSecondBinding>(R.layout.fragment_second) {

    private val args: SecondFragmentArgs by navArgs()
    private val viewModel: SecondViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val foo = args.foo
        val bar = args.bar
        Toast.makeText(requireContext(), "$foo -  $bar", Toast.LENGTH_SHORT).show()

        binding.btnSecondIncrement.setOnClickListener {
            viewModel.increment()
        }

        viewModel.value.observe(viewLifecycleOwner) { newValue ->
            binding.txtSecondValue.text = "$newValue"
        }
    }
}