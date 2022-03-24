package com.jgeron.dynamicrecyclerviewmenu.ui.model

data class UserMultipleSelectionPresentation(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val isHighlighted: Boolean = false,
    val isSelected: Boolean = false
){
    companion object {
        fun List<UserMultipleSelectionPresentation>.selectListOnListOfPresentationItems(
            presentationItems: List<Int>
        ) : List<UserMultipleSelectionPresentation> = this.map {
            it.copy(
                isSelected = presentationItems.contains(it.id)
            )
        }
    }

    fun changeSelectionPresentationItemOnList(
        presentationItems: List<UserMultipleSelectionPresentation>
    ) : List<UserMultipleSelectionPresentation> =
        presentationItems.map {
            it.copy(
                isSelected = if (this.id == it.id) !it.isSelected else it.isSelected
            )
        }
}
