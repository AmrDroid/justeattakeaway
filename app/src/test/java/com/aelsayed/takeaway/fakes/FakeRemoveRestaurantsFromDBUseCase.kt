package com.aelsayed.takeaway.fakes

import com.aelsayed.takeaway.domain.usecases.MainUseCase
import com.aelsayed.takeaway.presentation.model.RestaurantPresentation
import com.aelsayed.takeaway.utils.Data.restaurants
import kotlinx.coroutines.flow.Flow
import com.aelsayed.takeaway.utils.Result


class FakeRemoveRestaurantsFromDBUseCase(
    result: Result
) : BaseTestUseCase<String, String>(result),
    MainUseCase<String, Flow<String>> {

    override suspend fun invoke(params: String): Flow<String> = execute(params)

    override fun getValue(params: String): String {
        return ""
    }
}