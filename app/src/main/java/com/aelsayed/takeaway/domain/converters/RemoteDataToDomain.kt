package com.aelsayed.takeaway.domain.converters


import com.aelsayed.takeaway.domain.model.RestaurantItem
import com.aelsayed.takeaway.presentation.model.RestaurantPresentation

//from remote data layer to provide data to domain layer

internal fun List<RestaurantItem>.toViewModel(): List<RestaurantPresentation> {
    val list = ArrayList<RestaurantPresentation>()
    for (item in this) {
        list.add(item.toViewModel())
    }
    return list
}

internal fun RestaurantItem.toViewModel() = RestaurantPresentation(
    name = this.name,
    status = this.status,
    bestMatch = this.bestMatch,
    newest = this.newest,
    ratingAverage = this.ratingAverage,
    distance = this.distance,
    popularity = this.popularity,
    averageProductPrice = this.averageProductPrice,
    deliveryCosts = this.deliveryCosts,
    minCost = this.minCost
)


internal fun RestaurantPresentation.toData() = RestaurantItem(
    name = this.name,
    status = this.status,
    bestMatch = this.bestMatch,
    newest = this.newest,
    ratingAverage = this.ratingAverage,
    distance = this.distance,
    popularity = this.popularity,
    averageProductPrice = this.averageProductPrice,
    deliveryCosts = this.deliveryCosts,
    minCost = this.minCost
)
