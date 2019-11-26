package com.akshay.shaadi.data.source

import com.akshay.shaadi.data.ApiInterface
import com.akshay.shaadi.domain.getmatches.GetMatchesUseCase
import com.akshay.shaadi.domain.getmatches.Profile
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(val retrofitService: ApiInterface) :
    DataSource.RemoteDataSource {
    override suspend fun updateMatches(list: List<Profile>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMatches(): GetMatchesUseCase.Response {
        return try {
            GetMatchesUseCase.Response(retrofitService.getMatches().results.map {
                Profile(
                    name = it.name.first + " " + it.name.last,
                    age = "" + it.dob.age,
                    imageUrl = it.picture.large
                )
            })
        } catch (e: Exception) {
            GetMatchesUseCase.Response(emptyList())
        }
    }
}