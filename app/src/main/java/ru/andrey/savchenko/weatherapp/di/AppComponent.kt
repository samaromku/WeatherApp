package ru.andrey.savchenko.weatherapp.di

import dagger.Component
import ru.andrey.savchenko.weatherapp.main.MainInterActor
import javax.inject.Singleton

/**
 * Created by savchenko on 27.03.18.
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(interActor: MainInterActor)
}