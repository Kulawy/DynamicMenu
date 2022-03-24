package com.jgeron.dynamicrecyclerviewmenu.data.datagenerator

import com.jgeron.dynamicrecyclerviewmenu.domain.model.JobCategory
import com.jgeron.dynamicrecyclerviewmenu.domain.model.JobCategory.UNKNOWN
import com.jgeron.dynamicrecyclerviewmenu.domain.model.User
import io.github.serpro69.kfaker.faker
import java.lang.IllegalArgumentException
import java.util.*
import javax.inject.Inject


class UserGenerator @Inject constructor() : DataGenerator<User>{

    private val faker = faker {
        fakerConfig {
            random = Random()
            locale = "en"
            uniqueGeneratorRetryLimit = 128
        }
    }

    private fun getJobPosition() =
        when(faker.random.nextInt(6)){
            0 -> JobCategory.ADMINISTRATION
            1 -> JobCategory.MANAGEMENT
            2 -> JobCategory.SERVICE
            3 -> JobCategory.EXTERNAL_WORKER
            4 -> JobCategory.INTERNAL_WORKER
            else -> UNKNOWN
        }


    @Throws(IllegalArgumentException::class)
    override fun generateElements(count: Int): List<User> {
        if (count <= 0){
            throw IllegalArgumentException("BAD INPUT")
        }
        else return mutableListOf<User>().apply {
            for(i in 0..count){
                val nick = faker.funnyName.name()
                add(
                    User(
                        faker.random.nextInt(),
                        faker.name.firstName(),
                        faker.name.lastName(),
                        nick,
                        faker.internet.email(nick),
                        faker.address.city(),
                        faker.address.country(),
                        Random().nextBoolean(),
                        faker.yoda.quotes(),
                        getJobPosition()
                    )
                )
            }
        }
    }

}