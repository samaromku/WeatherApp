package ru.andrey.savchenko.weatherapp.mainactivity

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.andrey.savchenko.weatherapp.App
import ru.andrey.savchenko.weatherapp.network.WeatherService
import javax.inject.Inject

/**
 * Created by savchenko on 27.03.18.
 */
class MainInterActor {
    val API_KEY = "7bc11ba0d151135974d466d4c45aeefe"
    @Inject
    lateinit var service: WeatherService

    init {
        App.appComponent?.inject(this)
    }

    fun getWeather() {
        service.getWeatherPerWeek("Санкт-Петербург",
//                "day",
//                "",
//                "",
                API_KEY)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ r -> println(r) },
                        { t -> t.printStackTrace() })
    }
}