package com.aelsayed.takeaway.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.aelsayed.takeaway.presentation.activities.MainActivity.Companion.REST_ITEM
import com.aelsayed.takeaway.presentation.model.RestaurantPresentation
import takeaway.databinding.ActivityDetailBinding

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val restaurantItem = intent.getParcelableExtra<RestaurantPresentation>(REST_ITEM)

        binding.tvRestaurantName.text = restaurantItem?.name
        binding.tvOpeningState.text = restaurantItem?.status
        binding.ivFavorite.isSelected = restaurantItem?.isFav == true
        binding.tvMinimumOrder.text = restaurantItem?.minCost.toString()
        binding.bestMatch.text = restaurantItem?.bestMatch.toString()
        binding.newest.text = restaurantItem?.newest.toString()
        binding.ratingAverage.text = restaurantItem?.ratingAverage.toString()
        binding.distance.text = restaurantItem?.distance.toString()
        binding.popularity.text = restaurantItem?.popularity.toString()
        binding.averageProductPrice.text = restaurantItem?.averageProductPrice.toString()
        binding.deliveryCosts.text = restaurantItem?.deliveryCosts.toString()
    }
}