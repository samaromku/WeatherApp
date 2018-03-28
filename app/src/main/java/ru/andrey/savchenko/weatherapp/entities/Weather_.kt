package ru.andrey.savchenko.weatherapp.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


/**
 * Created by savchenko on 28.03.18.
 */
data class Weather_(
        @SerializedName("id")
        @Expose
        var id: Int = 0,
        @SerializedName("main")
        @Expose
        var main: String? = null,
        @SerializedName("description")
        @Expose
        var description: String? = null,
        @SerializedName("icon")
        @Expose
        var icon: String? = null
)