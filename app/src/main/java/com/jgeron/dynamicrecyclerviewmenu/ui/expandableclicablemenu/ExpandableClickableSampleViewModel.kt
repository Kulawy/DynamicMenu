package com.jgeron.dynamicrecyclerviewmenu.ui.expandableclicablemenu

import androidx.lifecycle.ViewModel
import com.jgeron.dynamicrecyclerviewmenu.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ExpandableClickableSampleViewModel @Inject constructor(
    private val userRepository: UserRepository
): ViewModel() {



}