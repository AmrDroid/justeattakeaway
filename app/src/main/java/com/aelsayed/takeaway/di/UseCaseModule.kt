package com.aelsayed.takeaway.di

import com.aelsayed.takeaway.domain.repository.IRestaurantsRepository
import com.aelsayed.takeaway.domain.usecases.*
import com.aelsayed.takeaway.presentation.model.RestaurantPresentation
import kotlinx.coroutines.flow.Flow
import org.koin.dsl.module
import org.koin.core.qualifier.named

val useCasesModule = module {

    single(named(PARAMS.AllRestaurants)) { providePopularUseCase(get()) }
    single(named(PARAMS.GET_RESTAURANT)) { provideGetRestaurantsFromDBUseCase(get()) }
    single(named(PARAMS.INSERT_RESTAURANT)) { provideInsertRestaurantsToDBUseCase(get()) }
    single(named(PARAMS.REMOVE_FAV)) { provideRemoveRestaurantsFromDBUseCase(get()) }

}

fun providePopularUseCase(
    restaurantRepository: IRestaurantsRepository
): MainUseCase<Int, Flow<List<RestaurantPresentation>>> {
    return GetAllRestaurantsUseCase(restaurantRepository)
}


fun provideGetRestaurantsFromDBUseCase(
    restaurantRepository: IRestaurantsRepository
): MainUseCase<Int, Flow<List<RestaurantPresentation>>> {
    return GetAllRestaurantsFromDBUseCase(restaurantRepository)
}


fun provideInsertRestaurantsToDBUseCase(
    restaurantRepository: IRestaurantsRepository
): MainUseCase<RestaurantPresentation, Flow<Long>> {
    return InsertFavRestaurantsUseCase(restaurantRepository)
}


fun provideRemoveRestaurantsFromDBUseCase(
    restaurantRepository: IRestaurantsRepository
): MainUseCase<String, Flow<String>> {
    return RemoveFavRestaurantsFromDBUseCase(restaurantRepository)
}


object PARAMS {
    const val AllRestaurants = "FETCH_RESTAURANT"
    const val GET_RESTAURANT = "FETCH_RESTAURANT_DB"
    const val INSERT_RESTAURANT = "INSERT_RESTAURANT_DB"
    const val REMOVE_FAV = "remove_fav"
}