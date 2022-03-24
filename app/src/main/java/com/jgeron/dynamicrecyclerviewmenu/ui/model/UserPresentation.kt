package com.jgeron.dynamicrecyclerviewmenu.ui.model

data class UserPresentation(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val isHighlighted: Boolean = false
) {
    companion object {
        fun List<UserPresentation>.selectItemOnListOfPresentationItems(
            selectedItemId: Int
        ): List<UserPresentation> = this.map {
            it.copy(
                isHighlighted = it.id == selectedItemId
            )
        }

        fun List<UserPresentation>.changeSelectionItemOnListOfPresentationItems(
            selectedItemId: Int
        ): List<UserPresentation> = this.map {
            it.copy(
                isHighlighted = if (it.id == selectedItemId) !it.isHighlighted else it.isHighlighted
            )
        }
    }
}
