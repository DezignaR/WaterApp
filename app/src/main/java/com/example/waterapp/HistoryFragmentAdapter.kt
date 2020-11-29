package com.example.waterapp

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.waterapp.AppSettings.inflate
import com.example.waterapp.data.WaterData
import kotlinx.android.synthetic.main.item_history_fragment.view.*
import java.text.SimpleDateFormat
import java.util.*

class HistoryFragmentAdapter(
    var list: List<WaterData>,
    private val onItemClick: (WaterData) -> Unit,
) : RecyclerView.Adapter<HistoryFragmentAdapter.HistoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder =
        HistoryViewHolder(parent.inflate(R.layout.item_history_fragment))

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class HistoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(water: WaterData) {
            with(itemView) {
                tvVolume.text = context.getString(R.string.count_water, water.volume)
                tvTime.text = dateFormatted(water.date)

                ivDelete.setOnClickListener {
                    onItemClick(water)
                }
            }
        }

        private fun dateFormatted(date: Date): String =
            SimpleDateFormat("HH:mm", Locale("RU")).format(date)
    }

    fun setData(list: List<WaterData>) {
        this.list = list
        notifyDataSetChanged()
    }
}