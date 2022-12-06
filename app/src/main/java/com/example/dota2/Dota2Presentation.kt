package com.example.dota2

import retrofit2.http.GET
import retrofit2.Call

interface Dota2Presentation {

    @GET("character/2")
    fun getCharacterById(): Call<Any>

}