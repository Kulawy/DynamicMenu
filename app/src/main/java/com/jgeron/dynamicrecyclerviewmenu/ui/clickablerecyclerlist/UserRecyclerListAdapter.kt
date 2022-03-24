package com.jgeron.dynamicrecyclerviewmenu.ui.clickablerecyclerlist

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jgeron.dynamicrecyclerviewmenu.R
import com.jgeron.dynamicrecyclerviewmenu.databinding.UserPresentationItemViewBinding
import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation

class UserRecyclerListAdapter(
    private val onItemClickCall: (Int) -> Unit
) : ListAdapter<UserPresentation, ViewHolder>(
    UserPresentationDiffUtilItemCallback
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = UserPresentationItemViewBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return UserPresentationViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as UserPresentationViewHolder).bind(position)
    }

    inner class UserPresentationViewHolder(
        private val itemBinding: UserPresentationItemViewBinding
    ) : RecyclerView.ViewHolder(itemBinding.root){

        fun bind(position: Int){
            val bindingItem = getItem(position)
            itemBinding.userPresentationItemFirstName.text = bindingItem.firstName
            itemBinding.userPresentationItemLastName.text = bindingItem.lastName
            setViewBaseOnUserPresentationState(bindingItem.isHighlighted)
            itemBinding.userPresentationItemRoot.setOnClickListener {
                onItemClickCall(bindingItem.id)
            }
        }

        private fun setViewBaseOnUserPresentationState(isHighlighted: Boolean){
            if ( isHighlighted ){
                itemBinding.root.setCardBackgroundColor(
                    ContextCompat.getColor(itemView.context, R.color.red)
                )
                itemBinding.userPresentationItemFirstName.let {
                    it.setTypeface( it.typeface, Typeface.BOLD)
                }
                itemBinding.userPresentationItemLastName.typeface = Typeface.DEFAULT_BOLD
            }
            else {
                itemBinding.root.setCardBackgroundColor(
                    ContextCompat.getColor(itemView.context, R.color.grey_light)
                )
                itemBinding.userPresentationItemFirstName.typeface = Typeface.DEFAULT
                itemBinding.userPresentationItemLastName.typeface = Typeface.DEFAULT
            }
        }
    }

}