package com.jgeron.dynamicrecyclerviewmenu.ui.expandablecheckboxmenu

import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserMultipleSelectionPresentation

data class ExpandableCheckboxMenuState(
    val selectedPresentationItemsIds: List<Int> = emptyList(),
    val presentationItems: List<UserMultipleSelectionPresentation> = emptyList(),
    val error: Throwable? = null
)
