package com.example.waterapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.general_fragment.*

class GeneralFragment : Fragment(R.layout.general_fragment) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        btnChangeVolume.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        ChangeDialogFragment.newInstance().show(childFragmentManager, "")
    }
}