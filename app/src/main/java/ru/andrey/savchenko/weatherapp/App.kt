package ru.andrey.savchenko.weatherapp

import android.app.Application
import ru.andrey.savchenko.weatherapp.di.AppComponent
import ru.andrey.savchenko.weatherapp.di.AppModule
import ru.andrey.savchenko.weatherapp.di.DaggerAppComponent

/**
 * Created by savchenko on 27.03.18.
 */
class App:Application() {

    override fun onCreate() {
        super.onCreate()
        component()
    }

    companion object {
        var appComponent: AppComponent? = null

        fun component(): AppComponent? {
            appComponent = DaggerAppComponent
                    .builder()
                    .appModule(AppModule())
                    .build()
            return appComponent
        }
    }
}