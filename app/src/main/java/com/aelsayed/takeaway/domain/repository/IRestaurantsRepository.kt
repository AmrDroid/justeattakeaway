package com.aelsayed.takeaway.domain.repository

import com.aelsayed.takeaway.domain.model.RestaurantItem

interface IRestaurantsRepository {

    suspend fun getAllRestaurants(): List<RestaurantItem>?

    suspend fun getAllFavRestaurants(): List<RestaurantItem>?

    suspend fun insertFavRestaurant(restaurant: RestaurantItem?): Long?

    suspend fun removeFavRestaurant(name: String)

}