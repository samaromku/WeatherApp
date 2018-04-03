package ru.tander.pharmacy.base.basemvp

import io.reactivex.disposables.CompositeDisposable

/**
 * Created by savchenko on 03.04.18.
 */
abstract class BasePresenter<T> {
    protected var view: T? = null
    protected val cp = CompositeDisposable()

    fun onAttachView(view: T?){
        this.view = view
        onViewAttached()
    }

    open fun onDetachView(){
        this.view = null
        cp.clear()
    }

    abstract fun onViewAttached()
}