package com.bokchi.runningapp.di

import android.app.Application
import com.bokchi.runningapp.db.AppDatabase
import com.bokchi.runningapp.db.RunningAppDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object APPModule {


    @Singleton
    @Provides
    fun getAppDB(context: Application): AppDatabase {
        return AppDatabase.getAppDB(context)
    }

    @Singleton
    @Provides
    fun getDao(appDB: AppDatabase): RunningAppDao {
        return appDB.getDAO()
    }
}