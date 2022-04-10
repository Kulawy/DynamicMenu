package com.jgeron.dynamicrecyclerviewmenu.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jgeron.dynamicrecyclerviewmenu.data.repository.UserRepository
import com.jgeron.dynamicrecyclerviewmenu.di.DefaultDispatcher
import com.jgeron.dynamicrecyclerviewmenu.ui.common.changeMultipleSelectionOnListOfPresentationItems
import com.jgeron.dynamicrecyclerviewmenu.ui.common.changeSingleSelectionOnListOfPresentationItems
import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClickableRecyclerListViewModel @Inject constructor(
    private val userRepository: UserRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _stateRecyclerList: MutableStateFlow<ClickableRecyclerListState> =
        MutableStateFlow(ClickableRecyclerListState())
    val stateRecyclerList: StateFlow<ClickableRecyclerListState> = _stateRecyclerList

    fun fetchOneThousandUsers() {
        viewModelScope.launch(defaultDispatcher) {
            userRepository.populateUsers(1000)
            var usersPresentations: List<UserPresentation>
            userRepository.getUsers().fold(
                {
                    usersPresentations = it.map { user ->
                        UserPresentation(user.id, user.firstName, user.lastName)
                    }
                    _stateRecyclerList.update {
                            state -> state.copy(userPresentationsList = usersPresentations)
                    }
                },
                {
                    _stateRecyclerList.update { state -> state.copy(error = it) }
                }
            )
        }
    }

    fun onSingleSelectUserPresentationClick(userId: Int) {
        viewModelScope.launch(defaultDispatcher) {
            userRepository.getUserById(userId).fold(
                { user ->
                    _stateRecyclerList.update { state ->
                        state.copy(
                            userPresentationsList = _stateRecyclerList.value.userPresentationsList
                                .changeSingleSelectionOnListOfPresentationItems(userId),
                            currentSelectedUser = user
                        )
                    }
                },
                { _stateRecyclerList.update { state -> state.copy(error = it) } }
            )
        }
    }

    fun onMultipleSelectUserPresentationClick(userId: Int) {
        viewModelScope.launch(defaultDispatcher) {
            userRepository.getUserById(userId).fold(
                { user ->
                    _stateRecyclerList.update { state ->
                        state.copy(
                            userPresentationsList = _stateRecyclerList.value.userPresentationsList
                                .changeMultipleSelectionOnListOfPresentationItems(userId),
                            currentSelectedUser = user
                        )
                    }
                },
                { _stateRecyclerList.update { state -> state.copy(error = it) } }
            )
        }
    }
}
