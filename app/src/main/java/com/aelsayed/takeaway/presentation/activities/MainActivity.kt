package com.aelsayed.takeaway.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.aelsayed.takeaway.presentation.adapter.RestaurantAdapter
import com.aelsayed.takeaway.presentation.model.RestaurantItemClickListener
import com.aelsayed.takeaway.presentation.model.RestaurantPresentation
import com.aelsayed.takeaway.presentation.model.ViewState
import com.aelsayed.takeaway.presentation.util.showLoading
import com.aelsayed.takeaway.presentation.viewmodel.RestaurantsViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import takeaway.R
import takeaway.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), RestaurantItemClickListener {

    private val restaurantsViewModel: RestaurantsViewModel by viewModel()

    private lateinit var binding: ActivityMainBinding
    private var restaurants: List<RestaurantPresentation> = emptyList()
    private var favRestaurants: List<RestaurantPresentation> = emptyList()
    private lateinit var adapter: RestaurantAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        restaurantsViewModel.getAllRestaurant()
        restaurantsViewModel.getAllFavRestaurantFromDB()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {

                launch {
                    restaurantsViewModel.favRestaurantsState.collect {
                        when (it) {
                            is ViewState.Success -> {
                                favRestaurants = it.restaurants
                                binding.progressBar.showLoading(false)
                            }
                            is ViewState.Error -> {
                                Snackbar.make(binding.layout, it.message, Snackbar.LENGTH_SHORT)
                                    .show()
                                binding.progressBar.showLoading(false)
                            }
                            is ViewState.Loading ->
                                binding.progressBar.showLoading(it.isLoading)
                        }
                    }
                }

                launch {
                    restaurantsViewModel.restaurantsState.collect {
                        when (it) {
                            is ViewState.Success -> {
                                setUpPopularRecyclerView(it.restaurants)
                                restaurants = it.restaurants
                                binding.progressBar.showLoading(false)
                            }
                            is ViewState.Error -> {
                                Snackbar.make(binding.layout, it.message, Snackbar.LENGTH_SHORT)
                                    .show()
                                binding.progressBar.showLoading(false)
                            }
                            is ViewState.Loading ->
                                binding.progressBar.showLoading(it.isLoading)
                        }
                    }
                }
            }
        }


    }

    private fun setUpPopularRecyclerView(restaurantList: List<RestaurantPresentation>) {

        for (restaurant in restaurantList) {
            val items = favRestaurants.filter { it.name.equals(restaurant.name) }
            restaurant.isFav = items.isNotEmpty()
        }

        binding.restaurantsRecycler.layoutManager = LinearLayoutManager(this, VERTICAL, false)
        adapter = RestaurantAdapter(
            sortByFav(restaurantList), this
        )
        binding.restaurantsRecycler.adapter = adapter
    }


    override fun onItemFavoriteButtonClicked(
        restaurantItem: RestaurantPresentation,
        isSelected: Boolean
    ) {

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                restaurantItem.isFav = !restaurantItem.isFav
                if (!isSelected)
                    restaurantsViewModel.removeFavRestaurantFromDB(restaurantItem.name)
                else
                    restaurantsViewModel.insertFavRestaurantToDB(restaurantItem)

            }
        }
    }

    override fun onItemClicked(item: RestaurantPresentation) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(REST_ITEM, item)
        startActivity(intent)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.sortByOpenState -> {
                adapter.setData(sortByState(restaurants))
                true
            }
            R.id.sortByDistance -> {
                adapter.setData(restaurants.sortedBy {
                    it.distance
                })
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun sortByState(restaurants: List<RestaurantPresentation>): List<RestaurantPresentation> {
        val restaurantsGrouped = restaurants.groupBy({ it.status }, { it })

        val sortedList = ArrayList<RestaurantPresentation>()
        restaurantsGrouped[getString(R.string.open)]
            ?.let { sortedList.addAll(it.toList()) }
        restaurantsGrouped[getString(R.string.order_ahead)]
            ?.let { sortedList.addAll(it.toList()) }
        restaurantsGrouped[getString(R.string.closed)]
            ?.let { sortedList.addAll(it.toList()) }
        return sortedList
    }

    private fun sortByFav(restaurants: List<RestaurantPresentation>): List<RestaurantPresentation> {
        val restaurantsGrouped = restaurants.groupBy({ it.isFav }, { it })
        val sortedList = ArrayList<RestaurantPresentation>()

        restaurantsGrouped[true]?.let {
            sortedList.addAll(sortByState(it))
        }
        restaurantsGrouped[false]?.let {
            sortedList.addAll(sortByState(it))
        }
        return sortedList
    }


    companion object {
        const val REST_ITEM = "REST"
    }
}
