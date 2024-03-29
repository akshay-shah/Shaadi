package com.akshay.shaadi.presentation.di

import android.content.Context
import androidx.room.Room
import com.akshay.shaadi.data.repository.InternetConnectionChecker
import com.akshay.shaadi.data.repository.Repository
import com.akshay.shaadi.data.repository.RepositoryImplementation
import com.akshay.shaadi.data.source.DataSource
import com.akshay.shaadi.data.source.localdatasource.LocalDataSourceImpl
import com.akshay.shaadi.data.source.localdatasource.database.AppDatabase
import com.akshay.shaadi.data.source.remotedatasource.ApiInterface
import com.akshay.shaadi.data.source.remotedatasource.RemoteDataSourceImpl
import com.akshay.shaadi.domain.getmatches.GetMatchesUseCase
import com.akshay.shaadi.presentation.view.home.MatchesActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named


@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    internal abstract fun provideMainActivityBinding(): MatchesActivity
}

@Module
class ApiModule {
    val url = "https://randomuser.me/"
    @Provides
    fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun getApiService(retrofit: Retrofit): ApiInterface = retrofit.create(
        ApiInterface::class.java
    )
}

@Module(includes = [DataSourceModule::class, UtilityModule::class])
class RepositoryModule {
    @Provides
    fun provideRepository(
        localDataSource: DataSource.LocalDataSource,
        remoteDataSource: DataSource.RemoteDataSource,
        internetConnectionChecker: InternetConnectionChecker
    ): Repository =
        RepositoryImplementation(localDataSource, remoteDataSource, internetConnectionChecker)
}

@Module(includes = [ApiModule::class, DataBaseModule::class])
class DataSourceModule {

    @Provides
    fun provideLocalDataSource(appDatabase: AppDatabase): DataSource.LocalDataSource =
        LocalDataSourceImpl(appDatabase)

    @Provides
    fun provideRemoteDataSource(retrofitService: ApiInterface): DataSource.RemoteDataSource =
        RemoteDataSourceImpl(retrofitService)

}

@Module(includes = [RepositoryModule::class])
class UseCaseModule {
    @Provides
    fun provideGetMatchesUseCase(repository: Repository) = GetMatchesUseCase(repository)
}

@Module(includes = [ContextModule::class])
class DataBaseModule() {
    @Provides
    fun provideRoom(
        context: Context
    ) = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "user.db"
    ).build()


}

@Module
class ContextModule() {
    @Provides
    @Named("ActivityContext")
    fun providesContext(context: Context): Context = context
}

@Module(includes = [ContextModule::class])
class UtilityModule() {
    @Provides
    fun provideConnectionChecker(context: Context): InternetConnectionChecker {
        return InternetConnectionChecker(context)
    }
}



