package com.akshay.shaadi.data.source.remotedatasource

import com.akshay.shaadi.data.model.ServerResponse
import retrofit2.http.GET

interface ApiInterface{
    @GET("api/?results=10")
    suspend fun getMatches(): ServerResponse
}