package com.bokchi.runningapp.db.runnginLogDB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "runningLog")
class RunningLogEntity (

    @PrimaryKey(autoGenerate = true)@ColumnInfo(name = "id") val id: Int= 0,
    @ColumnInfo(name = "log") val log: String
)