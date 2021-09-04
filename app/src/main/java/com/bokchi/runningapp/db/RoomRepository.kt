package com.bokchi.runningapp.db

import javax.inject.Inject

class RoomRepository @Inject constructor(private val appDao: RunningAppDao) {

    fun getRecords(): List<RunningLogEntity> {
        return appDao.getRecords()
    }

    fun insertRecord(runningLogEntity: RunningLogEntity) {
        appDao.insertRecord(runningLogEntity)
    }
}