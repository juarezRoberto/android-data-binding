package com.juarez.android.databinding.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.navArgs
import com.juarez.android.databinding.BaseFragment
import com.juarez.android.databinding.R
import com.juarez.android.databinding.databinding.FragmentSecondBinding

class SecondFragment : BaseFragment<FragmentSecondBinding>(R.layout.fragment_second) {

    private val args: SecondFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val foo = args.foo
        val bar = args.bar
        Toast.makeText(requireContext(), "$foo -  $bar", Toast.LENGTH_SHORT).show()
    }
}