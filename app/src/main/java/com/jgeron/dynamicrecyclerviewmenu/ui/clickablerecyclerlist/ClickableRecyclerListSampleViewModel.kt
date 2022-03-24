package com.jgeron.dynamicrecyclerviewmenu.ui.clickablerecyclerlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jgeron.dynamicrecyclerviewmenu.common.utils.updateValue
import com.jgeron.dynamicrecyclerviewmenu.data.repository.UserRepository
import com.jgeron.dynamicrecyclerviewmenu.di.DefaultDispatcher
import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation
import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation.Companion.changeSelectionItemOnListOfPresentationItems
import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation.Companion.selectItemOnListOfPresentationItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ClickableRecyclerListSampleViewModel @Inject constructor(
    private val userRepository: UserRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _stateRecyclerList: MutableStateFlow<ClickableRecyclerListSampleState> =
        MutableStateFlow(ClickableRecyclerListSampleState())
    val stateRecyclerList: StateFlow<ClickableRecyclerListSampleState> = _stateRecyclerList

    fun fetchOneThousandUsers() {
        viewModelScope.launch(defaultDispatcher) {
            userRepository.populateUsers(1000)
            var usersPresentations: List<UserPresentation> = listOf()
            userRepository.getUsers().fold(
                {
                    usersPresentations = it.map { user ->
                        UserPresentation(user.id, user.firstName, user.lastName)
                    }
                    _stateRecyclerList.updateValue { copy(userPresentationsList = usersPresentations) }
                },
                {
                    _stateRecyclerList.updateValue { copy(error = it) }
                }
            )
        }
    }

    fun onUserPresentationClick(userId: Int) {
        viewModelScope.launch(defaultDispatcher) {
            userRepository.getUserById(userId).fold(
                { user ->
                    _stateRecyclerList.updateValue {
                        copy(
                            userPresentationsList = _stateRecyclerList.value.userPresentationsList
                                .changeSelectionItemOnListOfPresentationItems(userId),
                            currentSelectedUser = user
                        )
                    }
                },
                {_stateRecyclerList.updateValue { copy(error = it) } }
            )
        }
    }

}