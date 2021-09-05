package com.bokchi.runningapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface RunningAppDao {

    @Query("SELECT * FROM runningLog ORDER BY id DESC")
    fun getRecords(): List<RunningLogEntity>


    @Insert
    fun insertRecord(userEntity: RunningLogEntity)


    @Query("DELETE from runningLog")
    fun deleteLogAll()

}