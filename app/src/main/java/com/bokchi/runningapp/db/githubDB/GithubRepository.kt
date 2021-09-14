package com.bokchi.runningapp.db.githubDB

import javax.inject.Inject

class GithubRepository @Inject constructor(private val appDao : GithubDao){

    fun getGithubData() : List<GithubDataEntity> {
        return appDao.getGithubData()
    }


}