package com.jgeron.dynamicrecyclerviewmenu.ui.viewmodel

import com.jgeron.dynamicrecyclerviewmenu.domain.model.User
import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation

data class ClickableRecyclerListSampleState(
    val userPresentationsList: List<UserPresentation> = listOf(),
    val currentSelectedUser: User? = null,
    val error: Throwable? = null
)