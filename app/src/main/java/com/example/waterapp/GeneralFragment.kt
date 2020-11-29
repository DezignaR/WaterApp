package com.example.waterapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.waterapp.data.WaterData
import kotlinx.android.synthetic.main.general_fragment.*
import java.util.*

class GeneralFragment : Fragment(R.layout.general_fragment) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        setGlassVolume(AppSettings.volume)
        setCountWater()
    }

    private fun initListeners() {
        btnChangeVolume.setOnClickListener { showDialog() }
        ivWaterGlass.setOnClickListener {
            setDataDB()
            setCountWater()
        }
        btnHistory.setOnClickListener {
            WaterApplication.INSTANCE.router.navigateTo(Screens.HistoryScreen(::getAllDB))
        }
    }

    private fun setDataDB() {
        val waterData = WaterData(date = Date(), volume = AppSettings.volume)
        WaterApplication.INSTANCE.database.waterDataDao().insertAll(waterData)
    }

    private fun getAllDB(): List<WaterData> {
        return WaterApplication.INSTANCE.database.waterDataDao().getAll()
    }

    private fun setCountWater() {
        var count = 0
        val wd = getAllDB()
        for (i in wd.indices) {
            count += wd[i].volume
        }
        if (count < 1000) {
            tvCountWater.text = getString(R.string.count_water, count)
        } else {
            val liters = count / 1000
            val ml = count % 1000
            tvCountWater.text = getString(R.string.count_water_liters, liters, ml)
        }
    }

    private fun setGlassVolume(volume: Int) {
        if (volume < 1000) {
            tvGlassVolume.text = getString(R.string.count_water, AppSettings.volume)
        } else {
            val liters = volume / 1000
            val ml = volume % 1000
            tvGlassVolume.text = getString(R.string.count_water_liters, liters, ml)
        }
    }

    private fun showDialog() {
        ChangeVolumeFragment.newInstance(::setGlassVolume).show(childFragmentManager, "")
    }
}