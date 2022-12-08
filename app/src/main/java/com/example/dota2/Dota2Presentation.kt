package com.example.dota2

import retrofit2.http.GET
import retrofit2.Call

interface Dota2Presentation {

    @GET("api/heroes")
    fun getCharacterById(): Call<DataModel>

}