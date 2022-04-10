package com.jgeron.dynamicrecyclerviewmenu.ui.singleselectrecyclerlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jgeron.dynamicrecyclerviewmenu.databinding.FragmentSingleSelectRecyclerListBinding
import com.jgeron.dynamicrecyclerviewmenu.domain.model.User
import com.jgeron.dynamicrecyclerviewmenu.ui.adapters.UserRecyclerListAdapter
import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation
import com.jgeron.dynamicrecyclerviewmenu.ui.viewmodel.ClickableRecyclerListViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@WithFragmentBindings
@AndroidEntryPoint
class SingleSelectRecyclerListFragment : Fragment() {

    private var _binding: FragmentSingleSelectRecyclerListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ClickableRecyclerListViewModel by viewModels()

    private lateinit var listAdapter: UserRecyclerListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSingleSelectRecyclerListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchOneThousandUsers()
        initRecyclerView()
        observeState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initRecyclerView() = with(binding.clickableListFragmentRecyclerview) {
        listAdapter = UserRecyclerListAdapter(::onUserSelected)
        adapter = listAdapter
        layoutManager = LinearLayoutManager(requireContext())
        addItemDecoration(
            DividerItemDecoration(context, (layoutManager as LinearLayoutManager).orientation)
        )
    }

    private fun onUserSelected(presentationItemId: Int) {
        viewModel.onSingleSelectUserPresentationClick(presentationItemId)
    }

    private fun observeState() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.stateRecyclerList.collectLatest { state ->
                bindUserPresentationElements(state.userPresentationsList)
                bindCurrentSelectedUser(state.currentSelectedUser)
                bindError(state.error)
            }
        }
    }

    private fun bindCurrentSelectedUser(currentSelectedUser: User?) = with(binding) {
        currentSelectedUser?.let {
            clickableListFragmentFirstName.text = it.firstName
            clickableListFragmentLastName.text = it.lastName
            clickableListFragmentCity.text = it.city
            clickableListFragmentCountry.text = it.country
            clickableListFragmentEmail.text = it.email
            clickableListFragmentMotto.text = it.motto
        }
    }

    private fun bindUserPresentationElements(userPresentationElements: List<UserPresentation>) {
        listAdapter.submitList(userPresentationElements)
    }

    private fun bindError(error: Throwable?) {
        if (error != null) {
            Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
        }
    }
}