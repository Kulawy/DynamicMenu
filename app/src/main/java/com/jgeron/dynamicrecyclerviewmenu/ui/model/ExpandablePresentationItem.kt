package com.jgeron.dynamicrecyclerviewmenu.ui.model

abstract class ExpandablePresentationItem(
    private var expanded: Boolean = false
) : PoliTypeViewItem, PresentationItem{

    abstract var children: List<UserPresentation>

    var parent: ExpandablePresentationItem? = null

    abstract fun getItemId(): Long

    fun isExpandable(): Boolean {
        return children.isNotEmpty()
    }

    fun isExpanded(): Boolean {
        return expanded
    }

    fun expand() {
        this.expanded = true
    }

    fun collapse(){
        this.expanded = false
    }

}
