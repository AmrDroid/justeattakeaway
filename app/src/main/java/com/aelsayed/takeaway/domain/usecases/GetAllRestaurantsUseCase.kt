package com.aelsayed.takeaway.domain.usecases


import android.util.Log
import com.aelsayed.takeaway.domain.base.traceErrorException
import com.aelsayed.takeaway.domain.converters.toViewModel
import com.aelsayed.takeaway.domain.repository.IRestaurantsRepository
import com.aelsayed.takeaway.presentation.model.RestaurantPresentation
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class GetAllRestaurantsUseCase(
    private val restaurantsRepository: IRestaurantsRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) : MainUseCase<Int, Flow<List<RestaurantPresentation>>> {

    override suspend operator fun invoke(params: Int) = flow {
        withContext(defaultDispatcher)
        {
            try {
                restaurantsRepository.getAllRestaurants()?.let {
                    withContext(Dispatchers.Main)
                    {
                        emit(it.toViewModel())
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.d("Error occurred: ", traceErrorException(e).message.toString())
            }
        }
    }
}