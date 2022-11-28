package com.example.dota2

import retrofit2.http.GET
import retrofit2.Call

interface RickAndMortyService {

    @GET("character/2")
    fun getCharacterById(): Call<Any>

}