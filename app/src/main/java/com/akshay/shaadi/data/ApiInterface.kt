package com.akshay.shaadi.data

import com.akshay.shaadi.data.model.matchesmodel.MatchesModel
import retrofit2.http.GET

interface ApiInterface{
    @GET("api/?results=10")
    suspend fun getMatches() : MatchesModel
}