package com.akshay.shaadi.data.source.localdatasource

import com.akshay.shaadi.data.Profile
import com.akshay.shaadi.data.Result
import com.akshay.shaadi.data.source.DataSource
import com.akshay.shaadi.data.source.localdatasource.database.AppDatabase
import com.akshay.shaadi.data.source.localdatasource.database.User
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(val database: AppDatabase) :
    DataSource.LocalDataSource {
    override suspend fun updateMatches(list: List<Profile>) {
        try {
            database.userDao().insertAllOrders(list.map {
                User(
                    name = it.name,
                    age = it.age.toInt(),
                    imageUrl = it.imageUrl
                )
            })
        } catch (e: Exception) {

        }
    }


    override suspend fun getMatches(): Result<List<Profile>> {
        try {
            val list = database.userDao().getAllUsers()
            if (list.isNotEmpty()) {
                return Result.Success(list.map { Profile(it.name!!, "" + it.age, it.imageUrl!!) })
            } else {
                return Result.Success(emptyList())
            }
        } catch (e: Exception) {
            return Result.Error(e)
        }
    }
}