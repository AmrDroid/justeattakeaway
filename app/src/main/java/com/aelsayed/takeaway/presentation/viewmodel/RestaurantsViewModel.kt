package com.aelsayed.takeaway.presentation.viewmodel

import android.util.Log
import com.aelsayed.takeaway.domain.usecases.*
import com.aelsayed.takeaway.presentation.model.RestaurantPresentation
import com.aelsayed.takeaway.presentation.model.ViewState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect

class RestaurantsViewModel(
    private val getRestaurantsUseCase: MainUseCase<Int, Flow<List<RestaurantPresentation>>>,
    private val getAllRestaurantsFromDBUseCase: MainUseCase<Int, Flow<List<RestaurantPresentation>>>,
    private val insertFavRestaurantsToDBUseCase: MainUseCase<RestaurantPresentation, Flow<Long>>,
    private val removeFavRestaurantsFromDBUseCase: MainUseCase<String, Flow<String>>

) : BaseViewModel() {


    private val _restaurantsState = MutableStateFlow<ViewState>(ViewState.Loading(false))
    val restaurantsState: StateFlow<ViewState> = _restaurantsState

    private val _favRestaurantsState = MutableStateFlow<ViewState>(ViewState.Loading(false))
    val favRestaurantsState: StateFlow<ViewState> = _favRestaurantsState

    private val _insertFavRestaurantsState = MutableStateFlow<Long>(0)


    override val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        _restaurantsState.value = ViewState.Error(exception.toString())
    }

    fun getAllRestaurant() {
        _restaurantsState.value = ViewState.Loading(true)
        launchCoroutine {
            getRestaurantsUseCase.invoke(0).collect { restaurants ->
                _restaurantsState.value = ViewState.Success(restaurants)
            }
        }
    }

    fun getAllFavRestaurantFromDB() {
        _favRestaurantsState.value = ViewState.Loading(true)
        launchCoroutine {
            getAllRestaurantsFromDBUseCase.invoke(0).collect { restaurants ->
                _favRestaurantsState.value = ViewState.Success(restaurants)
                Log.d("fav restaurants", restaurants.toString())

            }
        }
    }

    fun removeFavRestaurantFromDB(name: String) {
        launchCoroutine {
            removeFavRestaurantsFromDBUseCase.invoke(name).collect {
                Log.d("State = ", it)
            }
        }

    }


    fun insertFavRestaurantToDB(restaurantPresentation: RestaurantPresentation) {
        launchCoroutine {
            insertFavRestaurantsToDBUseCase.invoke(restaurantPresentation).collect {
                _insertFavRestaurantsState.value = it
            }
        }
    }


}

