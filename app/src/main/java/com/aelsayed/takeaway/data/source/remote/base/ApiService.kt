package com.aelsayed.takeaway.data.source.remote.base

import com.aelsayed.takeaway.data.models.RestaurantsRequest
import retrofit2.http.GET

interface ApiService {

    @GET("sample.json")
    suspend fun getRestaurants(): RestaurantsRequest
}