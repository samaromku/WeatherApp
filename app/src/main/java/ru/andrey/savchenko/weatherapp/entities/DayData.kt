package ru.andrey.savchenko.weatherapp.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 28.03.18.
 */
data class DayData(
        @SerializedName("dt")
        @Expose
        var dt: Int,
        @SerializedName("temp")
        @Expose
        var temp: Temp,
        @SerializedName("pressure")
        @Expose
        var pressure: Double,
        @SerializedName("humidity")
        @Expose
        var humidity: Int,
        @SerializedName("weather")
        @Expose
        var weather: List<Weather_>,
        @SerializedName("speed")
        @Expose
        var speed: Double,
        @SerializedName("deg")
        @Expose
        var deg: Int,
        @SerializedName("clouds")
        @Expose
        var clouds: Int,
        @SerializedName("snow")
        @Expose
        var snow: Double
)