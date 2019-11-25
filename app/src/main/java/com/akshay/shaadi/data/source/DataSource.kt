package com.akshay.shaadi.data.source

import com.akshay.shaadi.domain.repository.DataRepository

interface DataSource : DataRepository {
    interface LocalDataSource : DataSource
    interface RemoteDataSource : DataSource
}