package com.aelsayed.takeaway.data.models

import com.google.gson.annotations.SerializedName

data class RestaurantsRequest(
    @SerializedName("restaurants") var restaurants: ArrayList<Restaurant> = arrayListOf()
)