package com.aelsayed.takeaway.domain.usecases


import android.util.Log
import com.aelsayed.takeaway.domain.base.traceErrorException
import com.aelsayed.takeaway.domain.converters.toData
import com.aelsayed.takeaway.domain.repository.IRestaurantsRepository
import com.aelsayed.takeaway.presentation.model.RestaurantPresentation
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class InsertFavRestaurantsUseCase(
    private val restaurantsRepository: IRestaurantsRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MainUseCase<RestaurantPresentation, Flow<Long>> {

    override suspend operator fun invoke(restaurant: RestaurantPresentation) = flow {
        withContext(defaultDispatcher)
        {
            try {
                restaurantsRepository.insertFavRestaurant(restaurant.toData())?.let {
                    withContext(Dispatchers.Main)
                    {
                        emit(it)
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("Error occurred: ", traceErrorException(e).message.toString())
            }
        }
    }
}