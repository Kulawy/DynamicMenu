package com.jgeron.dynamicrecyclerviewmenu.ui.expandableclicablemenu

import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation

data class ExpandableClickableSampleState(
    val userPresentationsList: List<UserPresentation> = listOf(),
    val error: Throwable? = null
)