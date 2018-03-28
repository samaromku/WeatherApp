package ru.andrey.savchenko.weatherapp.base

import android.support.v7.widget.RecyclerView
import android.view.View
import ru.andrey.savchenko.weatherapp.interfaces.OnItemClickListener
import kotlinx.android.extensions.LayoutContainer

open class BaseViewHolder<T>(override val containerView: View?) :
        RecyclerView.ViewHolder(containerView),
        View.OnClickListener,
        LayoutContainer{
    var clickListener: OnItemClickListener? = null

    open fun bind(t:T, clickListener: OnItemClickListener){
        this.clickListener = clickListener
    }

    init {
        itemView.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        clickListener?.onclick(adapterPosition)
    }
}