package com.aelsayed.takeaway.di

import com.aelsayed.takeaway.data.repository.RestaurantsRepositoryImp
import com.aelsayed.takeaway.data.source.local.RestaurantLocalDataSource
import com.aelsayed.takeaway.data.source.local.RestaurantLocalDataSourceImp
import com.aelsayed.takeaway.data.source.local.base.AppDatabase
import com.aelsayed.takeaway.data.source.remote.RestaurantsRemoteDataSource
import com.aelsayed.takeaway.data.source.remote.RestaurantsRemoteDataSourceImp
import com.aelsayed.takeaway.data.source.remote.base.ApiService
import com.aelsayed.takeaway.domain.repository.IRestaurantsRepository
import org.koin.dsl.module


val appModule = module {

    single { createLocalDataSource(get()) }
    single { createRemoteDataSource(get()) }
    single<IRestaurantsRepository> { RestaurantsRepositoryImp(get(), get()) }

}
fun createLocalDataSource(appDatabase: AppDatabase): RestaurantLocalDataSource {
    return RestaurantLocalDataSourceImp(appDatabase)
}

fun createRemoteDataSource(apiService: ApiService): RestaurantsRemoteDataSource {
    return RestaurantsRemoteDataSourceImp(apiService)
}
