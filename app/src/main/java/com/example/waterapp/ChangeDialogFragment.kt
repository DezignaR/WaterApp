package com.example.waterapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ChangeDialogFragment : BottomSheetDialogFragment() {

    companion object {

        fun newInstance():ChangeDialogFragment = ChangeDialogFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.change_value_dialog, container)

    fun back() {
        dismiss()
    }
}