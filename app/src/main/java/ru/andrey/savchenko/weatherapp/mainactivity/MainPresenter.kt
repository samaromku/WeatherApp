package ru.andrey.savchenko.weatherapp.mainactivity

import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import ru.andrey.savchenko.weatherapp.entities.ErrorResponse

/**
 * Created by savchenko on 27.03.18.
 */
class MainPresenter(val view: MainView) {
    private val interActor = MainInterActor()

    fun getWeather(city: String) {
        interActor.getWeather(city)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({ r -> r.list?.let { view.updateAdapter(it) } },
                        { t ->
                            if (t is HttpException) {
                                val errorResponse: ErrorResponse =
                                        Gson().fromJson<ErrorResponse>(t.response().errorBody()?.string(), ErrorResponse::class.java)
                                view.showError("Код ошибки: ${errorResponse.cod} \n" +
                                        "Текст ошибки: ${errorResponse.message}")
                                println(errorResponse)
                            }else{
                                view.showError(t.message.toString())
                            }
                            t.printStackTrace()
                        })
    }
}