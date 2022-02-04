package com.aelsayed.takeaway.di

import com.aelsayed.takeaway.presentation.viewmodel.RestaurantsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel {
        RestaurantsViewModel(
            get(named(PARAMS.AllRestaurants)),
            get(named(PARAMS.GET_RESTAURANT)),
            get(named(PARAMS.INSERT_RESTAURANT)),
            get(named(PARAMS.REMOVE_FAV))
        )
    }
}