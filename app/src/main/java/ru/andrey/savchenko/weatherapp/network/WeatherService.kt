package ru.andrey.savchenko.weatherapp.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.andrey.savchenko.weatherapp.entities.Weather

/**
 * Created by savchenko on 27.03.18.
 */
interface WeatherService {
    @GET("/data/2.5/forecast/daily")
    fun getWeatherPerWeek(
            @Query("q")cityName:String,
            @Query("cnt")days:String,
            @Query("appid")appid:String
            ):Single<Weather>
}