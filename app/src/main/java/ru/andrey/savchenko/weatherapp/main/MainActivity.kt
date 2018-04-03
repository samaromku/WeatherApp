package ru.andrey.savchenko.weatherapp.main

import android.app.AlertDialog
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import ru.andrey.savchenko.weatherapp.R
import ru.andrey.savchenko.weatherapp.entities.DayData
import ru.andrey.savchenko.weatherapp.interfaces.OnItemClickListener
import ru.tander.pharmacy.base.basemvp.PresenterGetter

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var presenter: MainPresenter
    val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = PresenterGetter.getPresenter(MainPresenter::class.java)
        etSearchCity.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                presenter.getWeather(etSearchCity.text.toString())
                return@OnEditorActionListener true
            }
            false
        })
        btnSearch.setOnClickListener { presenter.getWeather(etSearchCity.text.toString()) }
    }

    override fun onStart() {
        super.onStart()
        presenter.onAttachView(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.onDetachView()
    }

    override fun showError(error: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Ошибка")
                .setMessage(error)
                .setPositiveButton("ОК", { dialog, _ -> dialog.dismiss() })
        val errorDialog = builder.create()
        errorDialog.setOnShowListener {
            errorDialog.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(resources.getColor(R.color.colorPrimaryDark))
            errorDialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(resources.getColor(R.color.colorPrimaryDark))
        }
        errorDialog.show()
    }

    override fun updateAdapter(list: List<DayData>) {
        val adapter = MainAdapter(list, object : OnItemClickListener {
            override fun onclick(position: Int) {
                Log.d(TAG, position.toString())
            }
        })
        val layoutManager = LinearLayoutManager(this)
        rvWeather.layoutManager = layoutManager
        rvWeather.adapter = adapter
        rvWeather.addItemDecoration(DividerItemDecoration(rvWeather.context, layoutManager.orientation))
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun setCityName(cityName: String) {
        tvCityName.text = cityName
    }
}
