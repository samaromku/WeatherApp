package ru.andrey.savchenko.weatherapp.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 28.03.18.
 */
data class Temp(
        @SerializedName("day")
        @Expose
        var day: Double = 0.toDouble(),
        @SerializedName("min")
        @Expose
        var min: Double = 0.toDouble(),
        @SerializedName("max")
        @Expose
        var max: Double = 0.toDouble(),
        @SerializedName("night")
        @Expose
        var night: Double = 0.toDouble(),
        @SerializedName("eve")
        @Expose
        var eve: Double = 0.toDouble(),
        @SerializedName("morn")
        @Expose
        var morn: Double = 0.toDouble()
)