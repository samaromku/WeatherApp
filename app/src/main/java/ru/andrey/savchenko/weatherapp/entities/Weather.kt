package ru.andrey.savchenko.weatherapp.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 27.03.18.
 */
data class Weather(
        @SerializedName("cod")
        @Expose
        var cod: String? = null,
        @SerializedName("message")
        @Expose
        var message: Double = 0.toDouble(),
        @SerializedName("cnt")
        @Expose
        var cnt: Int = 0,
        @SerializedName("list")
        @Expose
        var list: List<DayData>? = null
)