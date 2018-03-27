package ru.andrey.savchenko.weatherapp.mainactivity

/**
 * Created by savchenko on 27.03.18.
 */
class MainPresenter (val view: MainView){
    private val interActor = MainInterActor()

    fun getWeather() {
        interActor.getWeather()
    }
}