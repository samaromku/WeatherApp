package ru.andrey.savchenko.weatherapp.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.andrey.savchenko.weatherapp.entities.Weather

/**
 * Created by savchenko on 27.03.18.
 */
interface WeatherService {
    @GET("/data/2.5/history/city")
    fun getWeatherPerWeek(
            @Query("q")cityName:String,
//            @Query("type")type:String,
//            @Query("start")start:String,
//            @Query("end")end:String,
            @Query("appid")appid:String
            ):Single<Weather>
}