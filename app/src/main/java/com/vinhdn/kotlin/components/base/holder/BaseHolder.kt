package com.vinhdn.kotlin.components.base.holder

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(item: T)
}