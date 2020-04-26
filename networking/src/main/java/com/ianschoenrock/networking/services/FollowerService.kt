package com.ianschoenrock.networking.services

import com.ianschoenrock.networking.interfaces.FollowerInterface
import com.ianschoenrock.networking.interfaces.RepositoryInterface
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FollowerService(user: String) {
    private val BASE_URL = "https://api.github.com/users/$user/"
    private var retrofit: Retrofit

    init {

        val interceptor = HttpLoggingInterceptor().
        setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient.Builder()
            .retryOnConnectionFailure(false)
            .addInterceptor(interceptor)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun getFollowers(): FollowerInterface {
        return retrofit.create<FollowerInterface>(FollowerInterface::class.java)
    }
}