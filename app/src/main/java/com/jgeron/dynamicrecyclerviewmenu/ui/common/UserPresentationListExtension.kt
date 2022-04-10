package com.jgeron.dynamicrecyclerviewmenu.ui.common

import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation

fun List<UserPresentation>.changeSingleSelectionOnListOfPresentationItems(
    selectedItemId: Int
): List<UserPresentation> = this.map {
    it.copy(
        isHighlighted = if (it.id == selectedItemId) !it.isHighlighted else false
    )
}

fun List<UserPresentation>.changeMultipleSelectionOnListOfPresentationItems(
    selectedItemId: Int
): List<UserPresentation> = this.map {
    it.copy(
        isHighlighted = if (it.id == selectedItemId) !it.isHighlighted else it.isHighlighted
    )
}

fun List<UserPresentation>.selectListOnListOfPresentationItems(
    presentationItems: List<Int>
): List<UserPresentation> = this.map {
    it.copy(
        isHighlighted = presentationItems.contains(it.id)
    )
}
