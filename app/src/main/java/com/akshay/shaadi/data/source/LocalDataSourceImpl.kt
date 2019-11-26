package com.akshay.shaadi.data.source

import com.akshay.shaadi.data.database.AppDatabase
import com.akshay.shaadi.data.database.User
import com.akshay.shaadi.domain.getmatches.GetMatchesUseCase
import com.akshay.shaadi.domain.getmatches.Profile
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
            emptyList<Nothing>()
        }
    }

    override suspend fun getMatches(): GetMatchesUseCase.Response {
        return try {
            val list = database.userDao().getAllUsers()
            GetMatchesUseCase.Response(list.map {
                Profile(
                    it.name!!,
                    "" + it.age,
                    it.imageUrl!!
                )
            })
        } catch (e: Exception) {
            GetMatchesUseCase.Response(emptyList())
        }
    }
}