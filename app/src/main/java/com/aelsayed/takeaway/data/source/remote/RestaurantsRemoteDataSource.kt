package com.aelsayed.takeaway.data.source.remote

import com.aelsayed.takeaway.data.models.RestaurantsRequest


interface RestaurantsRemoteDataSource {
    suspend fun getRestaurants(): RestaurantsRequest
}