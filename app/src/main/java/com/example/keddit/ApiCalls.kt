package com.example.keddit

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface ApiCalls {
    @GET("top.json?")
    fun getPosts(): Single<RedditNews>
}