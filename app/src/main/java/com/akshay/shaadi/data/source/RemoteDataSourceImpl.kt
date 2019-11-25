package com.akshay.shaadi.data.source

import com.akshay.shaadi.data.ApiInterface
import com.akshay.shaadi.domain.getmatches.GetMatchesUseCase
import com.akshay.shaadi.domain.getmatches.Profile
import java.lang.Exception
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(val retrofitService: ApiInterface) :
    DataSource.RemoteDataSource {

    override suspend fun getMatches(): GetMatchesUseCase.Response {
        return try {
            GetMatchesUseCase.Response(retrofitService.getMatches().results.map {
                Profile(
                    name = "Name : " + it.name.first + " " + it.name.last,
                    age = "Age : " + it.dob.age,
                    imageUrl = it.picture.large
                )
            })
        } catch (e: Exception) {
            GetMatchesUseCase.Response(emptyList())
        }
    }
}