package com.aelsayed.takeaway.presentation.model

sealed class ViewState {
    data class Success(val restaurants: List<RestaurantPresentation>) : ViewState()
    data class Error(val message: String) : ViewState()
    data class Loading(val isLoading: Boolean) : ViewState()
}