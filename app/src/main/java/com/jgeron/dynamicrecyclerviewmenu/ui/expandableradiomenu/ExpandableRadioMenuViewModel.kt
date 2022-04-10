package com.jgeron.dynamicrecyclerviewmenu.ui.expandableradiomenu

import androidx.lifecycle.ViewModel
import com.jgeron.dynamicrecyclerviewmenu.data.repository.UserRepository
import com.jgeron.dynamicrecyclerviewmenu.di.DefaultDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ExpandableRadioMenuViewModel @Inject constructor(
    private val userRepository: UserRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _state: MutableStateFlow<ExpandableRadioMenuState> =
        MutableStateFlow(ExpandableRadioMenuState())
    val state: StateFlow<ExpandableRadioMenuState> = _state

}