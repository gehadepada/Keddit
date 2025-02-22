package com.example.keddit

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetroConnection {
    @Volatile
    private var retrofit: Retrofit? = null

    @Synchronized
    fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://www.reddit.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create()) // Add RxJava3 call adapter
                .build()
        }
        return retrofit!!
    }

    val api: ApiCalls by lazy {
        getRetrofit().create(ApiCalls::class.java)
    }
}
