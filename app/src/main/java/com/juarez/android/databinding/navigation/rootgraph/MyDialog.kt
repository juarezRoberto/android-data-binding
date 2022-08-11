package com.juarez.android.databinding.navigation.rootgraph

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.juarez.android.databinding.databinding.MyDialogBinding

class MyDialog : BottomSheetDialogFragment() {

    private val viewModel: SecondViewModel by activityViewModels()
    private lateinit var binding: MyDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MyDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.value.observe(viewLifecycleOwner) { value ->
            binding.txtDialogValue.text = "$value"
        }
    }
}