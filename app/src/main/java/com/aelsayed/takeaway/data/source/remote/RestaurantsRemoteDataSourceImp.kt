package com.aelsayed.takeaway.data.source.remote

import com.aelsayed.takeaway.data.models.RestaurantsRequest
import com.aelsayed.takeaway.data.source.remote.base.ApiService

class RestaurantsRemoteDataSourceImp(private val apiService: ApiService) :
    RestaurantsRemoteDataSource {


    override suspend fun getRestaurants(): RestaurantsRequest {
        return apiService.getRestaurants()
    }
}