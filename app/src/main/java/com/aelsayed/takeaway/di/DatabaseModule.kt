package com.aelsayed.takeaway.di

import android.app.Application
import androidx.room.Room
import com.aelsayed.takeaway.data.source.local.base.AppDatabase
import org.koin.dsl.module


val databaseModule = module {

    single { createAppDatabase(get()) }

}

internal fun createAppDatabase(application: Application): AppDatabase {
    return Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        AppDatabase.DB_NAME
    ).build()
}