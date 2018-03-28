package ru.andrey.savchenko.weatherapp.mainactivity

import ru.andrey.savchenko.weatherapp.entities.DayData

/**
 * Created by savchenko on 27.03.18.
 */
interface MainView {
    fun showError(error:String)
    fun updateAdapter(list:List<DayData>)
}