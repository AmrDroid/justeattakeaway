package com.aelsayed.takeaway.data.models

import com.google.gson.annotations.SerializedName

data class SortingValues(
    @SerializedName("bestMatch") var bestMatch: Double,
    @SerializedName("newest") var newest: Double,
    @SerializedName("ratingAverage") var ratingAverage: Double,
    @SerializedName("distance") var distance: Int,
    @SerializedName("popularity") var popularity: Double,
    @SerializedName("averageProductPrice") var averageProductPrice: Int,
    @SerializedName("deliveryCosts") var deliveryCosts: Int,
    @SerializedName("minCost") var minCost: Int
)