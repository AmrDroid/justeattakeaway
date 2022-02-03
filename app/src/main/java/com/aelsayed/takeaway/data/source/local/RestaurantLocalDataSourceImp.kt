package com.aelsayed.takeaway.data.source.local

import com.aelsayed.takeaway.data.source.local.base.AppDatabase
import com.aelsayed.takeaway.data.source.local.entities.RestaurantEntity


class RestaurantLocalDataSourceImp(private val appDatabase: AppDatabase) :
    RestaurantLocalDataSource {


    override suspend fun getAllRestaurants(): List<RestaurantEntity>? {
        return appDatabase.localeDao.loadAll()
    }


    override suspend fun insertRestaurant(restaurant: RestaurantEntity?): Long? {
        return appDatabase.localeDao.insertRestaurant(restaurant)
    }

    override suspend fun removeRestaurant(name: String) {
         appDatabase.localeDao.deleteFavRestaurant(name)

    }
}