package com.jgeron.dynamicrecyclerviewmenu.ui.expandableclicablemenu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jgeron.dynamicrecyclerviewmenu.common.utils.updateValue
import com.jgeron.dynamicrecyclerviewmenu.data.repository.UserRepository
import com.jgeron.dynamicrecyclerviewmenu.di.DefaultDispatcher
import com.jgeron.dynamicrecyclerviewmenu.domain.model.User
import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExpandableClickableSampleViewModel @Inject constructor(
    private val userRepository: UserRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _state: MutableStateFlow<ExpandableClickableSampleState> =
        MutableStateFlow(ExpandableClickableSampleState())
    val state: StateFlow<ExpandableClickableSampleState> = _state

    fun fetchOneThousandUsers() {
        viewModelScope.launch(defaultDispatcher) {
            var usersPresentations: List<UserPresentation> = listOf()
            userRepository.getUsers(1000).fold(
                {
                    usersPresentations = it.map { user ->
                        UserPresentation(user.id, user.firstName, user.lastName)
                    }
                    _state.updateValue { copy(userPresentationsList = usersPresentations) }
                },
                {
                    _state.updateValue { copy(error = it) }
                }
            )
        }
    }

}