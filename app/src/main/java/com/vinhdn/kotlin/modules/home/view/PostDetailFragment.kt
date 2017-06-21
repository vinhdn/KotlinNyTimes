package com.vinhdn.kotlin.modules.home.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vinhdn.kotlin.R
import com.vinhdn.kotlin.components.base.view.BaseFragment
import com.vinhdn.kotlin.modules.home.model.HomeViewModel
import com.vinhdn.kotlin.modules.home.model.PostResponse

/**
 * Created by vinh on 5/23/17.
 */
class PostDetailFragment : BaseFragment(){

    companion object {
        fun getInstance() : PostDetailFragment {
            return PostDetailFragment()
        }
    }

    val headTv by lazy {
        view?.findViewById(R.id.headTv) as TextView
    }

    val contentTv by lazy {
        view?.findViewById(R.id.contentTv) as TextView
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_post_detail, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(activity).get(HomeViewModel::class.java)
        viewModel.postSeleted.observe(this, Observer<PostResponse> { t ->
            //Update UI
            headTv?.text = (t?.leadParagraph)
            contentTv?.text = (t?.snippet)
        })
    }
}