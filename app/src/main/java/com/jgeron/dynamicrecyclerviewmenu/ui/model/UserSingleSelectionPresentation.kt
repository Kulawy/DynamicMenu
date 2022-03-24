package com.jgeron.dynamicrecyclerviewmenu.ui.model

data class UserSingleSelectionPresentation(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val isHighlighted: Boolean = false,
    val isSelected: Boolean = false
){
    companion object {
        fun List<UserSingleSelectionPresentation>.selectListOnListOfPresentationItems(
            presentationItems: List<Int>
        ) : List<UserSingleSelectionPresentation> = this.map {
            it.copy(
                isSelected = presentationItems.contains(it.id)
            )
        }
    }

    fun changeSelectionPresentationItemOnList(
        presentationItems: List<UserSingleSelectionPresentation>
    ) : List<UserSingleSelectionPresentation> =
        presentationItems.map {
            it.copy(
                isSelected = if (this.id == it.id) !it.isSelected else it.isSelected
            )
        }
}
