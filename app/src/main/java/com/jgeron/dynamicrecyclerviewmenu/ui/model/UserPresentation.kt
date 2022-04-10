package com.jgeron.dynamicrecyclerviewmenu.ui.model

data class UserPresentation(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val isHighlighted: Boolean = false
)
