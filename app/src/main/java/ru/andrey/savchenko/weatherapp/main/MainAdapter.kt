package ru.andrey.savchenko.weatherapp.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_weather.*
import ru.andrey.savchenko.weatherapp.R
import ru.andrey.savchenko.weatherapp.base.BaseAdapter
import ru.andrey.savchenko.weatherapp.base.BaseViewHolder
import ru.andrey.savchenko.weatherapp.entities.DayData
import ru.andrey.savchenko.weatherapp.interfaces.OnItemClickListener
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by savchenko on 28.03.18.
 */
class MainAdapter(dataList: List<DayData>,
                  clickListener: OnItemClickListener) : BaseAdapter<DayData>(dataList, clickListener) {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder<DayData> {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.item_weather, parent, false)
        return WeatherHolder(view)
    }

    inner class WeatherHolder(itemView: View) : BaseViewHolder<DayData>(itemView) {
        override fun bind(t: DayData, clickListener: OnItemClickListener) {
            super.bind(t, clickListener)
            val celsius = t.temp.day - 273
            tvTemp.text = DecimalFormat("#.##").format(celsius) + "C"
            val date = Date(t.dt.toLong() * 1000)
            tvDate.text = SimpleDateFormat("dd.MM.yyyy").format(date)
        }
    }

}