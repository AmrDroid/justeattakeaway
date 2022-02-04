package com.aelsayed.takeaway.remote.repository

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aelsayed.takeaway.data.repository.RestaurantsRepositoryImp
import com.aelsayed.takeaway.data.source.local.RestaurantLocalDataSource
import com.aelsayed.takeaway.data.source.local.RestaurantLocalDataSourceImp
import com.aelsayed.takeaway.data.source.local.base.AppDatabase
import com.aelsayed.takeaway.data.source.remote.RestaurantsRemoteDataSource
import com.aelsayed.takeaway.data.source.remote.RestaurantsRemoteDataSourceImp
import com.aelsayed.takeaway.domain.repository.IRestaurantsRepository
import com.aelsayed.takeaway.remote.BaseClient
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
internal class RestaurantsRepositoryClient : BaseClient() {

    private lateinit var restaurantsRepo: IRestaurantsRepository
    private lateinit var remoteDataSource: RestaurantsRemoteDataSource
    private lateinit var localDataSource: RestaurantLocalDataSource

    @Before
    override fun setup() {
        super.setup()
        remoteDataSource = RestaurantsRemoteDataSourceImp(apiService)
        val context = ApplicationProvider.getApplicationContext<Context>()
        val db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        localDataSource = RestaurantLocalDataSourceImp(db)
        restaurantsRepo = RestaurantsRepositoryImp(remoteDataSource, localDataSource)

    }

    @Test
    fun get_restaurants_test() {
        runBlocking {
            val rests = restaurantsRepo.getAllRestaurants()
            Truth.assertThat(rests).isNotNull()
        }
    }


    @Test
    fun get_all_fav_restaurants_db_test() {
        runBlocking {
            val rests = restaurantsRepo.getAllFavRestaurants()
            Truth.assertThat(rests).isNotNull()
        }
    }
}
