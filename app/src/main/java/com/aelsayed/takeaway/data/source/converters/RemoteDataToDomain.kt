package com.aelsayed.takeaway.data.source.converters

import com.aelsayed.takeaway.data.models.Restaurant
import com.aelsayed.takeaway.domain.model.RestaurantItem

//from remote data layer to provide data to domain layer

internal fun List<Restaurant>.toDomain(): List<RestaurantItem> {
    val list = ArrayList<RestaurantItem>()
    for (item in this) {
        list.add(item.toDomain())
    }
    return list
}

internal fun Restaurant.toDomain() = RestaurantItem(
    name = this.name,
    status = this.status,
    bestMatch = this.sortingValues.bestMatch,
    newest = this.sortingValues.newest,
    ratingAverage = this.sortingValues.ratingAverage,
    distance = this.sortingValues.distance,
    popularity = this.sortingValues.popularity,
    averageProductPrice = this.sortingValues.averageProductPrice,
    deliveryCosts = this.sortingValues.deliveryCosts,
    minCost = this.sortingValues.minCost
)