package com.akshay.shaadi.data.repository

import com.akshay.shaadi.data.source.DataSource
import com.akshay.shaadi.domain.getmatches.GetMatchesUseCase
import com.akshay.shaadi.domain.getmatches.Profile

class RepositoryImplementation(
    private val localDataSource: DataSource.LocalDataSource,
    private val remoteDataSource: DataSource.RemoteDataSource,
    private val internetConnectionChecker: InternetConnectionChecker
) : Repository {
    override suspend fun updateMatches(list: List<Profile>) {
        localDataSource.updateMatches(list)
    }

    override suspend fun getMatches(): GetMatchesUseCase.Response {
        if (internetConnectionChecker.checkConnectivity()!!) {
            val list = remoteDataSource.getMatches()
            updateMatches(list.list)
            return list
        } else
            return localDataSource.getMatches()
    }
}
