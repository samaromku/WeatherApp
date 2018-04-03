package ru.tander.pharmacy.base.basemvp

import java.lang.ref.WeakReference

/**
 * Created by savchenko on 03.04.18.
 */
object PresenterGetter {
    private val presenters = HashMap<String, WeakReference<Any>>()

    fun<T> getPresenter(presenterClass: Class<T>):T{
        var presenter = presenters[presenterClass.name]?.get() as T
        if(presenter==null){
            presenter=presenterClass.newInstance()
        }
        presenters.put(presenterClass.name, WeakReference(presenter as Any))
        return presenter
    }
}