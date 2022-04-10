package com.jgeron.dynamicrecyclerviewmenu.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jgeron.dynamicrecyclerviewmenu.databinding.UserPresentationItemViewBinding
import com.jgeron.dynamicrecyclerviewmenu.databinding.UserPresentationParentItemViewBinding
import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation

class UserExpandableListAdapter(
    private val onItemClickCall: (Int) -> Unit
) : ListAdapter<UserPresentation, ViewHolder>(UserPresentationDiffUtilItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    inner class UserPresentationParentViewHolder(
        private val itemViewBinding: UserPresentationParentItemViewBinding
    ) : RecyclerView.ViewHolder(itemViewBinding.root) {

        fun bind(position: Int){

        }
    }

    inner class UserPresentationChildViewHolder(
        private val itemViewBinding: UserPresentationItemViewBinding
    ) : RecyclerView.ViewHolder(itemViewBinding.root) {

        fun bind(position: Int){

        }
    }
}