package com.example.randomcatfactapp

import com.example.randomcatfactapp.data.MeowFacts
import retrofit2.Response
import retrofit2.http.GET

interface CatInterface {

    @GET("?id=")
    suspend fun getAllCatFacts(): Response<MeowFacts>
}