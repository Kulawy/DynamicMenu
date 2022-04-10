package com.jgeron.dynamicrecyclerviewmenu.ui.expandablecheckboxmenu

import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation

data class ExpandableCheckboxMenuState(
    val selectedPresentationItemsIds: List<Int> = emptyList(),
    val presentationItems: List<UserPresentation> = emptyList(),
    val error: Throwable? = null
)
