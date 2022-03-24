package com.jgeron.dynamicrecyclerviewmenu.domain.model

data class User(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val nickName: String,
    val email: String,
    val city: String,
    val country: String,
    val speaksEnglish: Boolean,
    val motto: String,
    val position: JobCategory
)
