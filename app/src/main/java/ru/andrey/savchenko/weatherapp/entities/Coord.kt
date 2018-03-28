package ru.andrey.savchenko.weatherapp.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 28.03.18.
 */
data class Coord(
        @SerializedName("lon")
        @Expose
        var lon: Double = 0.toDouble(),
        @SerializedName("lat")
        @Expose
        var lat: Double = 0.toDouble()
)