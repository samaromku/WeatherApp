package ru.andrey.savchenko.weatherapp.di

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.andrey.savchenko.weatherapp.network.WeatherService
import javax.inject.Singleton

/**
 * Created by savchenko on 27.03.18.
 */
@Module
class AppModule {
    val BASE_URL = "http://api.openweathermap.org"

    @Provides
    @Singleton
    fun getRetrofit(): WeatherService {
        val interceptor = HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

        return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(WeatherService::class.java)
    }
}