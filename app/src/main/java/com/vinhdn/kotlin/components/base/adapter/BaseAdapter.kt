package com.vinhdn.kotlin.components.base.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

import com.vinhdn.kotlin.components.base.holder.BaseHolder
import com.vinhdn.kotlin.components.listener.OnItemClickListener

import java.util.ArrayList

import io.reactivex.functions.Function

open class BaseAdapter<T, VH : BaseHolder<T>> @JvmOverloads constructor(private val func0: Function<ViewGroup, VH>,
                                                                        private val onItemClickListener: OnItemClickListener<T>? = null) : RecyclerView.Adapter<VH>() {

    var items: MutableList<T> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, holderType: Int): VH? {
        var holder: VH? = null
        try {
            holder = func0.apply(viewGroup)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        if (holder == null) return null
        return holder
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.itemView.tag = holder.adapterPosition
        holder.itemView.setOnClickListener { view ->
            val p = view.tag as Int
            if (p != RecyclerView.NO_POSITION && onItemClickListener != null) {
                onItemClickListener!!.onItemClick(data[p])
            }
        }
        holder.bind(items!![position])
    }

    override fun getItemCount(): Int {
        if (items == null) return 0
        return items!!.size
    }

    val data: List<T>
        get() = items!!

    fun add(item: T) {
        if (this.items == null) this.items = mutableListOf()
        this.items!!.add(item)
        notifyItemInserted(items!!.size - 1)
    }

    @JvmOverloads fun addList(items: List<T>, isRefresh: Boolean = false) {
        if (this.items == null || isRefresh) this.items = ArrayList<T>()
        this.items!!.addAll(items)
        if (isRefresh)
            notifyDataSetChanged()
        else
            notifyItemRangeInserted(this.items!!.size - items.size, items.size)
    }
}