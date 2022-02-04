package com.aelsayed.takeaway.data.models

import com.google.gson.annotations.SerializedName

data class Restaurant (
    @SerializedName("name") var name: String,
    @SerializedName("status") var status: String,
    @SerializedName("sortingValues") var sortingValues: SortingValues
)