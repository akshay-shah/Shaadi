package com.akshay.shaadi.data.source

import com.akshay.shaadi.data.Profile
import com.akshay.shaadi.data.Result


interface DataSource {
    suspend fun getMatches(): Result<List<Profile>>
    suspend fun updateMatches(list: List<Profile>)
    interface LocalDataSource : DataSource
    interface RemoteDataSource : DataSource
}