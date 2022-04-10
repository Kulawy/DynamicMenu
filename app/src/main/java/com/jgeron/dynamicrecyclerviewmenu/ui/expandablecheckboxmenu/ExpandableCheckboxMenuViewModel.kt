package com.jgeron.dynamicrecyclerviewmenu.ui.expandablecheckboxmenu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jgeron.dynamicrecyclerviewmenu.common.utils.updateValue
import com.jgeron.dynamicrecyclerviewmenu.data.repository.UserRepository
import com.jgeron.dynamicrecyclerviewmenu.di.DefaultDispatcher
import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpandableCheckboxMenuViewModel @Inject constructor(
    private val userRepository: UserRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _state: MutableStateFlow<ExpandableCheckboxMenuState> =
        MutableStateFlow(ExpandableCheckboxMenuState())
    val state: StateFlow<ExpandableCheckboxMenuState> = _state

    fun updateSelectedItemsPresentation(selectedItems: List<UserPresentation>) {
        viewModelScope.launch {
            _state.updateValue {
                copy(selectedPresentationItemsIds = selectedItems.map { it.id })
            }
        }
    }
}
