package com.example.a17259211.helloworld.data.retrofit

import com.example.a17259211.helloworld.data.service.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private fun retrofit() = Retrofit.Builder().baseUrl("http://10.0.2.2").addConverterFactory(GsonConverterFactory.create()).build()

    fun createApiService() = retrofit().create(ApiService::class.java)

}