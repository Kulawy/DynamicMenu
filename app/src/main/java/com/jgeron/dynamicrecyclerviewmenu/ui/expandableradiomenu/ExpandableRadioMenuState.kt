package com.jgeron.dynamicrecyclerviewmenu.ui.expandableradiomenu

import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation

data class ExpandableRadioMenuState(
    val selectedPresentationItemId: Int? = null,
    val presentationItems: List<UserPresentation> = emptyList(),
    val error: Throwable? = null
)
