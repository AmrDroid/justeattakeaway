package com.aelsayed.takeaway.presentation.adapter

import android.content.Context
import android.os.Build

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.aelsayed.takeaway.presentation.model.RestaurantItemClickListener
import com.aelsayed.takeaway.presentation.model.RestaurantPresentation
import takeaway.R


class RestaurantAdapter(
    private var restaurantItemList: List<RestaurantPresentation>,
    private val restaurantItemClickListener: RestaurantItemClickListener
) : RecyclerView.Adapter<RestaurantItemRecyclerViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantItemRecyclerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.restaurants_item, parent, false)

        return RestaurantItemRecyclerViewHolder(view)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(
        holderRestaurant: RestaurantItemRecyclerViewHolder,
        position: Int
    ) {
        val item = restaurantItemList[position]

        holderRestaurant.name.text = item.name

        holderRestaurant.minimumOrder.text =
            setMinimumOrderText(holderRestaurant.minimumOrder.context, item.minCost!!)

        holderRestaurant.openState.text = item.status

        holderRestaurant.favoriteState.isSelected = item.isFav == true

        holderRestaurant.favoriteState.setOnClickListener {
            it.isSelected = !it.isSelected
            restaurantItemClickListener.onItemFavoriteButtonClicked(item, it.isSelected)
        }
        holderRestaurant.root.setOnClickListener {
            restaurantItemClickListener.onItemClicked(item)
        }
    }

    private fun setMinimumOrderText(context: Context, minimumOrderAmount: Int): String {
        return String.format(context.getString(R.string.minimum_order_pattern), minimumOrderAmount)
    }

    fun setData(restaurantsList: List<RestaurantPresentation>) {
        restaurantItemList = restaurantsList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return restaurantItemList.size
    }

}