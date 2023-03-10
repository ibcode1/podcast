package com.ib.podplay.service

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface ItunesService {
    @GET("/search?media=podcast")

    fun searchPodcastByTerm(@Query("term") term:String):
            Call<PodcastResponse>

    companion object{
        val instance:ItunesService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://itunes.apple.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(ItunesService::class.java)
        }
    }
}