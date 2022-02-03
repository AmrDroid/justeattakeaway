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

class RemoveFavRestaurantsFromDBUseCase(
    private val restaurantsRepository: IRestaurantsRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MainUseCase<String, Flow<String>> {

    override suspend operator fun invoke(name: String) = flow {
        withContext(defaultDispatcher)
        {
            try {
                restaurantsRepository.removeFavRestaurant(name).let {
                    withContext(Dispatchers.Main)
                    {
                        emit("removed.")
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("Error occurred: ", traceErrorException(e).message.toString())
            }
        }
    }
}