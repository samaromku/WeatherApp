package ru.andrey.savchenko.weatherapp.main

import com.google.gson.Gson
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import ru.andrey.savchenko.weatherapp.entities.ErrorResponse
import ru.tander.pharmacy.base.basemvp.BasePresenter

/**
 * Created by savchenko on 27.03.18.
 */
class MainPresenter : BasePresenter<MainView>() {
    private val interActor = MainInterActor()

    override fun onViewAttached() {

    }

    fun getWeather(city: String) {
        cp.add(interActor.getWeather(city)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnSubscribe { disposable -> view?.showProgress() }
                .doFinally({ view?.hideProgress() })
                .subscribe({ r ->
                    view?.setCityName(city.capitalize())
                    r.list?.let { view?.updateAdapter(it) } },
                        { t ->
                            if (t is HttpException) {
                                val errorResponse: ErrorResponse =
                                        Gson().fromJson<ErrorResponse>(t.response().errorBody()?.string(), ErrorResponse::class.java)
                                view?.showError("Код ошибки: ${errorResponse.cod} \n" +
                                        "Текст ошибки: ${errorResponse.message}")
                                println(errorResponse)
                            }else{
                                view?.showError(t.message.toString())
                            }
                            t.printStackTrace()
                        }))
    }
}