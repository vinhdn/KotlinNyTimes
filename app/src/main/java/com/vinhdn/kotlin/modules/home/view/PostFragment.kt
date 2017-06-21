package com.vinhdn.kotlin.modules.home.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.vinhdn.kotlin.R
import com.vinhdn.kotlin.modules.home.model.PostResponse
import io.reactivex.functions.Function
import retrofit2.Retrofit
import com.google.gson.GsonBuilder
import com.google.gson.Gson



/**
 * Created by vinh on 5/22/17.
 */
open class PostFragment : com.vinhdn.kotlin.components.base.view.BaseFragment(), com.vinhdn.kotlin.components.listener.OnItemClickListener<PostResponse> {

    companion object {
        fun getInstance(): com.vinhdn.kotlin.modules.home.view.PostFragment {
            return com.vinhdn.kotlin.modules.home.view.PostFragment()
        }
    }

    val recyclerView by lazy {
        view?.findViewById(com.vinhdn.kotlin.R.id.recyclerView) as android.support.v7.widget.RecyclerView?
    }

    val swipeRefresh by lazy {
        view?.findViewById(com.vinhdn.kotlin.R.id.swipeRefreshLayout) as android.support.v4.widget.SwipeRefreshLayout?
    }
    var viewModel: com.vinhdn.kotlin.modules.home.model.HomeViewModel? = null

    var adapter : ListPostAdapter? = null

    override fun onCreateView(inflater: android.view.LayoutInflater?, container: android.view.ViewGroup?, savedInstanceState: android.os.Bundle?): android.view.View? {
        val view: android.view.View? = inflater?.inflate(com.vinhdn.kotlin.R.layout.fragment_post, container, false)
        return view
    }

    override fun onViewCreated(view: android.view.View?, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = mutableListOf(com.vinhdn.kotlin.modules.home.model.PostResponse("url 1", leadParagraph = "Head 1", snippet = "snippet 1", multimedia = null),
                com.vinhdn.kotlin.modules.home.model.PostResponse("url 2", leadParagraph = "Head 2", snippet = "snippet 2", multimedia = null),
                com.vinhdn.kotlin.modules.home.model.PostResponse("url 3", leadParagraph = "Head 3", snippet = "snippet 3", multimedia = null))
        adapter = ListPostAdapter(func0 = Function<ViewGroup, ListPostAdapter.PostHolder> {
            it?.let {
                val viewL = LayoutInflater.from(context).inflate(R.layout.item_post, it, false)
                return@Function ListPostAdapter.PostHolder(viewL)
            }
        }, onItemClickListener = this)
        recyclerView?.setHasFixedSize(true)
        recyclerView?.layoutManager = android.support.v7.widget.LinearLayoutManager(context)
        recyclerView?.adapter = adapter
        viewModel = android.arch.lifecycle.ViewModelProviders.of(activity).get(com.vinhdn.kotlin.modules.home.model.HomeViewModel::class.java)
        observeLiveData()
        viewModel?.listPosts?.value = data
        viewModel?.isLoadingPost?.value = true
        viewModel?.getPosts()
    }

    private fun observeLiveData() {
        viewModel?.isLoadingPost?.observe(this, android.arch.lifecycle.Observer {
            it?.let {
                swipeRefresh?.isRefreshing = it
            }
        })
        viewModel?.listPosts?.observe(this, android.arch.lifecycle.Observer<MutableList<PostResponse>> {
            it?.let { adapter?.items = it }
        })
    }

    override fun onItemClick(item: com.vinhdn.kotlin.modules.home.model.PostResponse) {
        viewModel?.postSeleted?.value = item
        changeFragment(PostDetailFragment.Companion.getInstance(), true)
    }


}