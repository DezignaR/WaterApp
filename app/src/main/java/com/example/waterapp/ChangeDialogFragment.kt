package com.example.waterapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.waterapp.AppSettings.volume
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.change_value_dialog.*

class ChangeDialogFragment : BottomSheetDialogFragment() {

    companion object {

        fun newInstance(onClick: (Int) -> Unit): ChangeDialogFragment {
            val fragment = ChangeDialogFragment()
            fragment.onClick = onClick
            return fragment
        }
    }

    var onClick: (Int) -> Unit = {}

    override fun onAttach(context: Context) {
        super.onAttach(requireContext())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        setValueInput()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? = inflater.inflate(R.layout.change_value_dialog, container)

    private fun initListeners() {
        btnApply.setOnClickListener { setGlassVolume() }
    }

    private fun setValueInput() {
        etInputValue.setText(volume.toString())
    }

    private fun setGlassVolume() {
        if (etInputValue.text.toString() == "") {
            volume = 0
            onClick(volume)
            dismiss()
        } else {
            volume = ((etInputValue.text.toString()).toInt())
            onClick(volume)
            dismiss()
        }
    }
}