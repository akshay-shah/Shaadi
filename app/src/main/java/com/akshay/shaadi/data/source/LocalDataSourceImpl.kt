package com.akshay.shaadi.data.source

import com.akshay.shaadi.data.database.AppDatabase
import com.akshay.shaadi.domain.getmatches.GetMatchesUseCase
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(val database: AppDatabase) : DataSource.LocalDataSource {
    override suspend fun getMatches(): GetMatchesUseCase.Response {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}