package com.aelsayed.takeaway.presentation.model

interface RestaurantItemClickListener {

    fun onItemFavoriteButtonClicked(position: RestaurantPresentation,isSelected : Boolean)
    fun onItemClicked(position: RestaurantPresentation)

}
