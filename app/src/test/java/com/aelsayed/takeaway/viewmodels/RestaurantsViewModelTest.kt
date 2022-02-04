package com.aelsayed.takeaway.viewmodels

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.aelsayed.takeaway.fakes.FakeGetAllRestaurantsFromDBUseCase
import com.aelsayed.takeaway.fakes.FakeGetAllRestaurantsUseCase
import com.aelsayed.takeaway.fakes.FakeInsertRestaurantsToDBUseCase
import com.aelsayed.takeaway.fakes.FakeRemoveRestaurantsFromDBUseCase
import com.aelsayed.takeaway.presentation.viewmodel.RestaurantsViewModel
import com.google.common.truth.Truth
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import com.aelsayed.takeaway.utils.Result
import com.aelsayed.takeaway.presentation.model.ViewState
import com.aelsayed.takeaway.utils.Data

@RunWith(AndroidJUnit4::class)
@ExperimentalCoroutinesApi
class RestaurantsViewModelTest : BaseViewModelTest() {

    private lateinit var restaurantsViewModel: RestaurantsViewModel

    override fun prepareViewModel(result: Result) {

        val fakeGetAllRestaurantsUseCase = FakeGetAllRestaurantsUseCase(result)
        val fakeGetAllRestaurantsFromDBUseCase = FakeGetAllRestaurantsFromDBUseCase(result)
        val insertRestaurantsToDBUseCase = FakeInsertRestaurantsToDBUseCase(result)
        val removeRestaurantsFromDBUseCase = FakeRemoveRestaurantsFromDBUseCase(result)


        restaurantsViewModel = RestaurantsViewModel(
            fakeGetAllRestaurantsUseCase,
            fakeGetAllRestaurantsFromDBUseCase,
            insertRestaurantsToDBUseCase,
            removeRestaurantsFromDBUseCase
        )
    }

    @Test
    fun get_restaurants_success_state() {
        runBlocking {
            prepareViewModel(Result.SUCCESS)
            restaurantsViewModel.getAllRestaurant()
            Truth.assertThat(restaurantsViewModel.restaurantsState.value)
                .isEqualTo(ViewState.Success(Data.restaurants))
        }
    }
}