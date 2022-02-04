package com.aelsayed.takeaway.fakes

import com.aelsayed.takeaway.domain.usecases.MainUseCase
import com.aelsayed.takeaway.presentation.model.RestaurantPresentation
import com.aelsayed.takeaway.utils.Data.restaurants
import kotlinx.coroutines.flow.Flow
import com.aelsayed.takeaway.utils.Result


class FakeInsertRestaurantsToDBUseCase(
    result: Result
) : BaseTestUseCase<Long, RestaurantPresentation>(result),
    MainUseCase<RestaurantPresentation, Flow<Long>> {

    override suspend fun invoke(params: RestaurantPresentation): Flow<Long> = execute(params)

    override fun getValue(params: RestaurantPresentation): Long {
        return 0
    }
}