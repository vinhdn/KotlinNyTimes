package com.vinhdn.kotlin.modules.home.model

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.vinhdn.kotlin.components.base.model.BaseViewModel
import com.vinhdn.kotlin.manager.network.ApiRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by vinh on 5/23/17.
 */
class HomeViewModel(application: Application) : BaseViewModel(application){
    val listPosts : MutableLiveData<MutableList<PostResponse>> = MutableLiveData()
    val postSeleted : MutableLiveData<PostResponse> = MutableLiveData()

    val isLoadingPost : MutableLiveData<Boolean> = MutableLiveData()

    fun getPosts(){
        ApiRequest().getListPost("obamacare socialism")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    it?.let {
                        isLoadingPost.value = false
                        listPosts.value = it?.response?.docs.toMutableList()
                    }
                })
        val ii = 6
        if(ii in 1..6){
            println("dung")
        }
    }
}