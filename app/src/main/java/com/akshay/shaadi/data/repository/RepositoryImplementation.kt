package com.akshay.shaadi.data.repository

import com.akshay.shaadi.data.Result
import com.akshay.shaadi.data.source.DataSource
import com.akshay.shaadi.domain.getmatches.GetMatchesUseCase
import com.akshay.shaadi.domain.getmatches.Profile

class RepositoryImplementation(
    private val localDataSource: DataSource.LocalDataSource,
    private val remoteDataSource: DataSource.RemoteDataSource,
    private val internetConnectionChecker: InternetConnectionChecker
) : Repository {


    override suspend fun getMatches(): GetMatchesUseCase.Response {
        if (internetConnectionChecker.checkConnectivity()!!) {
            return when (val result = remoteDataSource.getMatches()) {
                is Result.Success -> {
                    localDataSource.updateMatches(result.data)
                    GetMatchesUseCase.Response(result.data.map {
                        Profile(
                            it.name,
                            it.age,
                            it.imageUrl
                        )
                    })
                }
                is Result.Error -> GetMatchesUseCase.Response(emptyList())
            }
        } else {
            return when (val result = localDataSource.getMatches()) {
                is Result.Success -> GetMatchesUseCase.Response(result.data.map {
                    Profile(
                        it.name,
                        it.age,
                        it.imageUrl
                    )
                })
                is Result.Error -> GetMatchesUseCase.Response(emptyList())
            }
        }
    }
}
