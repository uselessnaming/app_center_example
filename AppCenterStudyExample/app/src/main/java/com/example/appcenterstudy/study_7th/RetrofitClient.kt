package com.example.appcenterstudy.study_7th

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private val areaAPI : AreaAPI
    private const val baseUrl = "https://apis.data.go.kr/5110000/tobaccoRetailert/"

    init{
        var gson = GsonBuilder().setLenient().create()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        areaAPI = retrofit.create(AreaAPI::class.java)
    }

    fun getAreaAPI() : AreaAPI {
        return areaAPI
    }
}