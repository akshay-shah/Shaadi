package com.akshay.shaadi.data.repository

import com.akshay.shaadi.data.source.DataSource
import com.akshay.shaadi.domain.getmatches.GetMatchesUseCase

class RepositoryImplementation(
    val localDataSource: DataSource.LocalDataSource,
    val remoteDataSource: DataSource.RemoteDataSource
) : Repository {
    override suspend fun getMatches(): GetMatchesUseCase.Response {
        return remoteDataSource.getMatches()
    }
}