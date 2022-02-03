package com.aelsayed.takeaway.data.source.converters

import com.aelsayed.takeaway.data.source.local.entities.RestaurantEntity
import com.aelsayed.takeaway.domain.model.RestaurantItem


internal fun List<RestaurantEntity>.toDomain(): List<RestaurantItem> {
    val list = ArrayList<RestaurantItem>()
    for (item in this) {
        list.add(item.toDomain())
    }
    return list
}

internal fun RestaurantEntity.toDomain() = RestaurantItem(
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

internal fun RestaurantItem.toData() = RestaurantEntity(
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