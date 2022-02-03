package com.aelsayed.takeaway.data.source.local

import com.aelsayed.takeaway.data.source.local.entities.RestaurantEntity


interface RestaurantLocalDataSource {

    suspend fun getAllRestaurants(): List<RestaurantEntity>?

    suspend fun insertRestaurant(restaurant: RestaurantEntity?): Long?

    suspend fun removeRestaurant(name: String)

}