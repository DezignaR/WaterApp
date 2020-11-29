package com.example.waterapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.waterapp.data.WaterData
import kotlinx.android.synthetic.main.history_fragment.*

class HistoryFragment : Fragment(R.layout.history_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbar(toolbar)
        initRecyclerView(getAllDB())
    }

    private fun setupToolbar(toolbar: Toolbar) {
        (requireActivity() as AppCompatActivity).apply {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            toolbar.setNavigationIcon(R.drawable.ic_back)
            toolbar.setNavigationOnClickListener {
                WaterApplication.INSTANCE.router.exit()
            }
        }
    }
    lateinit var adapter:HistoryFragmentAdapter
    private fun initRecyclerView(List: List<WaterData>) {
        historyRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter =  HistoryFragmentAdapter(List, ::deleteValue)
        historyRecyclerView.adapter = adapter
    }

    private fun getAllDB(): List<WaterData> {
        return WaterApplication.INSTANCE.database.waterDataDao().getAll()
    }

    private fun deleteValue(water: WaterData) {

        WaterApplication.INSTANCE.database.waterDataDao().delete(water)
        adapter.setData(getAllDB())
    }
}