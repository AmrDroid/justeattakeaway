package com.aelsayed.takeaway.data.source.local.entities


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RestaurantEntity")
data class RestaurantEntity(
    @PrimaryKey
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