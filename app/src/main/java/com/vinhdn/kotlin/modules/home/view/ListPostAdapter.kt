package com.vinhdn.kotlin.modules.home.view

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.vinhdn.kotlin.R
import com.vinhdn.kotlin.components.base.adapter.BaseAdapter
import com.vinhdn.kotlin.components.base.holder.BaseHolder
import com.vinhdn.kotlin.components.listener.OnItemClickListener
import com.vinhdn.kotlin.modules.home.model.PostResponse
import io.reactivex.functions.Function
import kotlinx.android.synthetic.main.item_post.*

/**
 * Created by vinh on 5/23/17.
 */
class ListPostAdapter(func0: io.reactivex.functions.Function<ViewGroup, PostHolder>, onItemClickListener: com.vinhdn.kotlin.components.listener.OnItemClickListener<PostResponse>?)
    : com.vinhdn.kotlin.components.base.adapter.BaseAdapter<PostResponse, ListPostAdapter.PostHolder>(func0, onItemClickListener) {

    override fun onCreateViewHolder(viewGroup: android.view.ViewGroup, holderType: Int): com.vinhdn.kotlin.modules.home.view.ListPostAdapter.PostHolder? {
        return super.onCreateViewHolder(viewGroup, holderType)
    }

    class PostHolder(view: android.view.View) : com.vinhdn.kotlin.components.base.holder.BaseHolder<PostResponse>(view) {

        val headTv by lazy {
            view?.findViewById(com.vinhdn.kotlin.R.id.headTv) as android.widget.TextView?
        }

        val contentTv by lazy {
            view?.findViewById(com.vinhdn.kotlin.R.id.contentTv) as android.widget.TextView?
        }

        val thumbIv by lazy {
            view?.findViewById(com.vinhdn.kotlin.R.id.avatarIv) as android.widget.ImageView?
        }

        override fun bind(item: com.vinhdn.kotlin.modules.home.model.PostResponse) {
            headTv?.text = item.leadParagraph
            contentTv?.text = item.snippet
            if(item.multimedia?.size != null && item?.multimedia?.size!! > 0) {
                com.bumptech.glide.Glide.with(itemView?.context)
                        .load("http://www.nytimes.com/" + item.multimedia[0].url)
                        .into(thumbIv)
            }else{
                com.bumptech.glide.Glide.with(itemView?.context)
                        .load(com.vinhdn.kotlin.R.mipmap.ic_launcher)
                        .into(thumbIv)
            }

        }

    }
}