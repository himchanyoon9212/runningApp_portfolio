package com.bokchi.runningapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bokchi.runningapp.db.githubDB.GithubDao
import com.bokchi.runningapp.db.githubDB.GithubDataEntity
import com.bokchi.runningapp.db.runnginLogDB.RunningAppDao
import com.bokchi.runningapp.db.runnginLogDB.RunningLogEntity

@Database(entities = [RunningLogEntity::class ,GithubDataEntity::class], version = 5, exportSchema = true)
abstract class AppDatabase: RoomDatabase() {

    abstract fun getDAO(): RunningAppDao
    abstract fun getGithubDAO(): GithubDao

    companion object {

        private var dbINSTANCE: AppDatabase? = null

        fun getAppDB(context: Context): AppDatabase {
            if(dbINSTANCE == null) {
                dbINSTANCE = Room.databaseBuilder<AppDatabase>(context.applicationContext, AppDatabase::class.java, "RUNLOGDB")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
            }
            return dbINSTANCE!!
        }

//        fun getGithubDB


    }
}