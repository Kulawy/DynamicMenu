package com.jgeron.dynamicrecyclerviewmenu.ui.model

class ExpandableJobCategoryPresentationItem(
    override var children: List<UserPresentation>,
    override val id: Int,
    override var isSelected: Boolean
) : ExpandablePresentationItem() {

    override fun getItemId(): Long {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(): Int {
        TODO("Not yet implemented")
    }
}
