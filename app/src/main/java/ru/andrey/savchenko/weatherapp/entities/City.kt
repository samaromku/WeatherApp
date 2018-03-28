package ru.andrey.savchenko.weatherapp.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 28.03.18.
 */
data class City(
        @SerializedName("id")
        @Expose
        var id: Int = 0,
        @SerializedName("name")
        @Expose
        var name: String? = null,
        @SerializedName("coord")
        @Expose
        var coord: Coord? = null,
        @SerializedName("country")
        @Expose
        var country: String? = null,
        @SerializedName("population")
        @Expose
        var population: Int = 0
)