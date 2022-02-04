package com.aelsayed.takeaway.fakes

import com.aelsayed.takeaway.domain.usecases.MainUseCase
import com.aelsayed.takeaway.presentation.model.RestaurantPresentation
import com.aelsayed.takeaway.utils.Data.restaurants
import kotlinx.coroutines.flow.Flow
import com.aelsayed.takeaway.utils.Result


class FakeGetAllRestaurantsUseCase(
    result: Result
) : BaseTestUseCase<List<RestaurantPresentation>, Int>(result),
    MainUseCase<Int, Flow<List<RestaurantPresentation>>> {

    override suspend fun invoke(params: Int): Flow<List<RestaurantPresentation>> = execute(params)

    override fun getValue(params: Int): List<RestaurantPresentation> {
        return restaurants

    }

}