package ru.andrey.savchenko.weatherapp.base

import android.support.v7.widget.RecyclerView
import ru.andrey.savchenko.weatherapp.interfaces.OnItemClickListener

abstract class BaseAdapter <T> (
        private val dataList: List<T>,
        private val clickListener: OnItemClickListener): RecyclerView.Adapter<BaseViewHolder<T>>() {

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(dataList[position], clickListener)
    }
}