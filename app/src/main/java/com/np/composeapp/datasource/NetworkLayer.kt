package com.np.composeapp.datasource

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object NetworkLayer {

    private const val BASE_URL =
        "https://gist.githubusercontent.com/rosannaNaomy/"

    val interceptor : HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    val client : OkHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(interceptor)
    }.build()


    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
        .baseUrl(BASE_URL)
        .client(client)
        .build()

    private val userService: UserService by lazy{
        retrofit.create(UserService::class.java)
    }

    val apiClient = ApiClient(userService)
}