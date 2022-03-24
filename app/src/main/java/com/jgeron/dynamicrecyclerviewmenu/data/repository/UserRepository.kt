package com.jgeron.dynamicrecyclerviewmenu.data.repository

import com.jgeron.dynamicrecyclerviewmenu.data.datagenerator.DataGenerator
import com.jgeron.dynamicrecyclerviewmenu.domain.model.User
import java.lang.Exception
import java.lang.IllegalArgumentException
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val dataGenerator: DataGenerator<User>
) {
    private var usersList = emptyList<User>()

    fun populateUsers(count: Int){
        usersList = dataGenerator.generateElements(count)
    }

    fun getUsers(): Result<List<User>> =
        try {
            Result.success(usersList)
        } catch (e: Exception) {
            Result.failure(Exception("SOMETHING WENT WRONG ON FETCHING USERS"))
        }

    fun getUserById(userId: Int): Result<User?> =
        try {
            Result.success(usersList.firstOrNull{it.id == userId})
        } catch (e: Exception) {
            Result.failure(Exception("SOMETHING WENT WRONG ON SEARCHING USER"))
        }

}