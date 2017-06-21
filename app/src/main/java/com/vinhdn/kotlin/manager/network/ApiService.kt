package com.vinhdn.kotlin.manager.network

import com.vinhdn.kotlin.modules.home.model.NYTimesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by vinh on 5/23/17.
 */
interface ApiService {

    @GET("articlesearch.json")
    fun getListPost(@Query("q") q : String,
                    @Query("api-key") apiKey : String) : Observable<NYTimesResponse>
}