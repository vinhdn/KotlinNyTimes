package com.vinhdn.kotlin.manager.network

import com.vinhdn.kotlin.modules.home.model.NYTimesResponse
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by vinh on 5/23/17.
 */
class ApiRequest{

    var apiService : ApiService
    val API_KEY = "c2fede7bd9aea57c898f538e5ec0a1ee:6:68700045"
    init {

        var okHttpClient : OkHttpClient = OkHttpClient()

        var builder : Retrofit.Builder = Retrofit.Builder().client(okHttpClient)

        val retrofit = builder
                .baseUrl("http://api.nytimes.com/svc/search/v2/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    fun getListPost(q: String): Observable<NYTimesResponse> {
        return apiService.getListPost(q, API_KEY)
    }
}