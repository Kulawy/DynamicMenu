package com.jgeron.dynamicrecyclerviewmenu.ui.model

data class UserPresentation(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val isHighlighted: Boolean = false
) {
    companion object {
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
    }
}
