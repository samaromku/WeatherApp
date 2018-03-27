package ru.andrey.savchenko.weatherapp.mainactivity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ru.andrey.savchenko.weatherapp.R

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this)
        presenter.getWeather()
    }
}
