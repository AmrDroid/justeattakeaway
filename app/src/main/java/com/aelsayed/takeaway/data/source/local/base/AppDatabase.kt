package com.aelsayed.takeaway.data.source.local.base

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aelsayed.takeaway.data.source.local.base.AppDatabase.Companion.DB_VERSION
import com.aelsayed.takeaway.data.source.local.base.dao.RestaurantsDao
import com.aelsayed.takeaway.data.source.local.entities.RestaurantEntity

/**
 * To manage data items that can be accessed and updated & also maintain relationships between them
 */
@Database(entities = [RestaurantEntity::class], version = DB_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract val localeDao: RestaurantsDao

    companion object {
        const val DB_NAME = "RestaurantEntity.db"
        const val DB_VERSION = 1
    }
}