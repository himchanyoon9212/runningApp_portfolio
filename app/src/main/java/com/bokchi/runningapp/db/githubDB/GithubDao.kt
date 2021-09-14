package com.bokchi.runningapp.db.githubDB

import androidx.room.Dao
import androidx.room.Query
import com.bokchi.runningapp.db.runnginLogDB.RunningLogEntity


@Dao
interface GithubDao {

    @Query("SELECT * FROM githubData ORDER BY id DESC")
    fun getGithubData(): List<GithubDataEntity>


}