package com.aelsayed.takeaway.domain.model

data class RestaurantItem(
    var name: String,
    var status: String? = null,
    var bestMatch: Double? = null,
    var newest: Double? = null,
    var ratingAverage: Double? = null,
    var distance: Int? = null,
    var popularity: Double? = null,
    var averageProductPrice: Int? = null,
    var deliveryCosts: Int? = null,
    var minCost: Int? = null
)