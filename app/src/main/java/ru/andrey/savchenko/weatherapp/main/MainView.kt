package ru.andrey.savchenko.weatherapp.main

import ru.andrey.savchenko.weatherapp.entities.DayData
import ru.tander.pharmacy.base.basemvp.BaseView

/**
 * Created by savchenko on 27.03.18.
 */
interface MainView :BaseView{
    fun showError(error:String)
    fun updateAdapter(list:List<DayData>)
    fun showProgress()
    fun hideProgress()
    fun setCityName(cityName:String)
}