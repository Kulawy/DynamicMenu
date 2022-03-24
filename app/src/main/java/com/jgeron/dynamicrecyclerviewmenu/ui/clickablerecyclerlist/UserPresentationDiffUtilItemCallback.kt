package com.jgeron.dynamicrecyclerviewmenu.ui.clickablerecyclerlist

import androidx.recyclerview.widget.DiffUtil
import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation

object UserPresentationDiffUtilItemCallback :
    DiffUtil.ItemCallback<UserPresentation>() {

    override fun areItemsTheSame(oldItem: UserPresentation, newItem: UserPresentation): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: UserPresentation, newItem: UserPresentation): Boolean =
        oldItem == newItem

}
