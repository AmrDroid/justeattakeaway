package com.aelsayed.takeaway.data.source.local.base.dao

import androidx.room.*
import com.aelsayed.takeaway.data.source.local.entities.RestaurantEntity


/**
 * Provides access to [RestaurantEntity] underlying database
 * */
@Dao
interface RestaurantsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRestaurant(list: RestaurantEntity?): Long?

    @Query("SELECT * FROM RestaurantEntity")
    suspend fun loadAll(): List<RestaurantEntity>?

    @Query("DELETE FROM RestaurantEntity where name=:name")
    suspend fun deleteFavRestaurant(name : String)

}