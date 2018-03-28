package ru.andrey.savchenko.weatherapp.entities

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by savchenko on 28.03.18.
 */
data class ErrorResponse(
        @SerializedName("cod")
        @Expose
        var cod: String,
        @SerializedName("message")
        @Expose
        var message: String
)