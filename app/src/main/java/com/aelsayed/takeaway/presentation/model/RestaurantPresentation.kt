package com.aelsayed.takeaway.presentation.model

import android.os.Parcel
import android.os.Parcelable

data class RestaurantPresentation(
    var name: String,
    var status: String? = null,
    var bestMatch: Double? = null,
    var newest: Double? = null,
    var ratingAverage: Double? = null,
    var distance: Int? = null,
    var popularity: Double? = null,
    var averageProductPrice: Int? = null,
    var deliveryCosts: Int? = null,
    var minCost: Int? = null,
    var isFav: Boolean = false

) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as Boolean,
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(status)
        parcel.writeValue(bestMatch)
        parcel.writeValue(newest)
        parcel.writeValue(ratingAverage)
        parcel.writeValue(distance)
        parcel.writeValue(popularity)
        parcel.writeValue(averageProductPrice)
        parcel.writeValue(deliveryCosts)
        parcel.writeValue(minCost)
        parcel.writeValue(isFav)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {

        if (javaClass != other?.javaClass)
            return false

        other as RestaurantPresentation

        if (name != other.name) return false
        if (status != other.status) return false
        if (bestMatch != other.bestMatch) return false
        if (newest != other.newest) return false
        if (ratingAverage != other.ratingAverage) return false
        if (distance != other.distance) return false
        if (popularity != other.popularity) return false
        if (averageProductPrice != other.averageProductPrice) return false
        if (deliveryCosts != other.deliveryCosts) return false
        if (isFav != other.isFav) return false
        if (minCost != other.minCost) return false

        return true
    }

    companion object CREATOR : Parcelable.Creator<RestaurantPresentation> {
        override fun createFromParcel(parcel: Parcel): RestaurantPresentation {
            return RestaurantPresentation(parcel)
        }

        override fun newArray(size: Int): Array<RestaurantPresentation?> {
            return arrayOfNulls(size)
        }
    }
}
