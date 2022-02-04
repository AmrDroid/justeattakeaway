package com.aelsayed.takeaway.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import takeaway.R

class RestaurantItemRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val name: TextView = itemView.findViewById(R.id.tv_restaurantName)
    val minimumOrder: TextView = itemView.findViewById(R.id.tv_minimumOrder)
    val openState: TextView = itemView.findViewById(R.id.tv_openingState)
    val favoriteState: ImageView = itemView.findViewById(R.id.iv_favorite)
    val root: ConstraintLayout = itemView.findViewById(R.id.rootLayout)
}