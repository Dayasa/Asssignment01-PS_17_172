package com.example.assignment01.API

import android.telecom.Call
import com.example.assignment01.models.data
import com.example.assignment01.models.data
import com.example.assignment01.models.data

interface RetrofitAPIHandler {

    @GET("POST")
    fun getdata(): Call<List<data>>

    companion object{
        val API_URL = "https://jsonplaceholder.typicode.com/"

        fun create():RetrofitAPIHandler{
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(GsonConverterFactory.create())
                .baseUrl(API_URL)
                .build()
            return retrofit.create(RetrofitAPIHandler::class.java)
        }
    }
}