package com.jgeron.dynamicrecyclerviewmenu.ui.model

data class UserPresentation(
    override val id: Int,
    val firstName: String,
    val lastName: String,
    override var isSelected: Boolean = false
) : PresentationItem {
    companion object {
        fun List<UserPresentation>.changeSingleSelectionOnListOfPresentationItems(
            selectedItemId: Int
        ): List<UserPresentation> = this.map {
            it.copy(
                isSelected = if (it.id == selectedItemId) !it.isSelected else false
            )
        }

        fun List<UserPresentation>.changeMultipleSelectionOnListOfPresentationItems(
            selectedItemId: Int
        ): List<UserPresentation> = this.map {
            it.copy(
                isSelected = if (it.id == selectedItemId) !it.isSelected else it.isSelected
            )
        }

        fun List<UserPresentation>.selectListOnListOfPresentationItems(
            presentationItems: List<Int>
        ): List<UserPresentation> = this.map {
            it.copy(
                isSelected = presentationItems.contains(it.id)
            )
        }
    }
}
