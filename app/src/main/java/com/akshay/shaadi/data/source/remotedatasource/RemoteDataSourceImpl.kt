package com.akshay.shaadi.data.source.remotedatasource

import com.akshay.shaadi.data.Profile
import com.akshay.shaadi.data.Result
import com.akshay.shaadi.data.source.DataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(val retrofitService: ApiInterface) :
    DataSource.RemoteDataSource {
    override suspend fun updateMatches(list: List<Profile>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override suspend fun getMatches(): Result<List<Profile>> {
        try {
            val list = retrofitService.getMatches().results
            return if (list.isNotEmpty())
                Result.Success(list.map {
                    Profile(
                        it.name.first + " " + it.name.last,
                        "" + it.dob.age,
                        it.picture.large
                    )
                })
            else
                Result.Success(emptyList())
        } catch (e: Exception) {
            return Result.Error(e)
        }
    }
}