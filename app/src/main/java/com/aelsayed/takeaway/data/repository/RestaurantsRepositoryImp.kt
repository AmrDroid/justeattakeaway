package com.aelsayed.takeaway.data.repository

import com.aelsayed.takeaway.data.source.converters.toData
import com.aelsayed.takeaway.data.source.converters.toDomain
import com.aelsayed.takeaway.data.source.local.RestaurantLocalDataSource
import com.aelsayed.takeaway.data.source.remote.RestaurantsRemoteDataSource
import com.aelsayed.takeaway.domain.model.RestaurantItem
import com.aelsayed.takeaway.domain.repository.IRestaurantsRepository

/**
 * This class is responsible to choose a source for fetching data
 * Local data will be fetched using [RestaurantLocalDataSource]
 * and Remote data using [RestaurantsRemoteDataSource]
 * */
class RestaurantsRepositoryImp constructor(
    private val restaurantsRemoteDataSource: RestaurantsRemoteDataSource,
    private val restaurantLocalDataSource: RestaurantLocalDataSource
) : IRestaurantsRepository {


    override suspend fun getAllRestaurants(): List<RestaurantItem> {
        return restaurantsRemoteDataSource.getRestaurants().restaurants.toDomain()
    }

    override suspend fun getAllFavRestaurants(): List<RestaurantItem>? {
        return restaurantLocalDataSource.getAllRestaurants()?.toDomain()
    }

    override suspend fun insertFavRestaurant(restaurant: RestaurantItem?): Long? {
        return restaurantLocalDataSource.insertRestaurant(restaurant?.toData())
    }

    override suspend fun removeFavRestaurant(name: String) {
        return restaurantLocalDataSource.removeRestaurant(name)
    }
}