package com.jgeron.dynamicrecyclerviewmenu.data.repository

import com.jgeron.dynamicrecyclerviewmenu.data.datagenerator.DataGenerator
import com.jgeron.dynamicrecyclerviewmenu.domain.model.User
import java.lang.Exception
import java.lang.IllegalArgumentException
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val dataGenerator: DataGenerator<User>
) {

    fun getUsers(count: Int): Result<List<User>> =
        try {
            Result.success(dataGenerator.generateElements(count))
        }catch (e: IllegalArgumentException){
            Result.failure(e)
        }

}