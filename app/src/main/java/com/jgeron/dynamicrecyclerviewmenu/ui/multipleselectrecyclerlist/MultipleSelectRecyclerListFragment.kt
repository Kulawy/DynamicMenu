package com.jgeron.dynamicrecyclerviewmenu.ui.multipleselectrecyclerlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.jgeron.dynamicrecyclerviewmenu.databinding.FragmentMultipleSelectRecyclerListBinding
import com.jgeron.dynamicrecyclerviewmenu.domain.model.User
import com.jgeron.dynamicrecyclerviewmenu.ui.viewmodel.ClickableRecyclerListViewModel
import com.jgeron.dynamicrecyclerviewmenu.ui.adapters.UserRecyclerListAdapter
import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@WithFragmentBindings
@AndroidEntryPoint
class MultipleSelectRecyclerListFragment : Fragment() {

    private val viewModel: ClickableRecyclerListViewModel by viewModels()
    private var _binding: FragmentMultipleSelectRecyclerListBinding? = null
    private val binding get() = _binding!!

    private lateinit var listAdapter: UserRecyclerListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMultipleSelectRecyclerListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchOneThousandUsers()
        initRecyclerView()
        observeState()
    }

    private fun initRecyclerView() = with(binding.fragmentmultipleselectrecyclerlistRecyclerview) {
        listAdapter = UserRecyclerListAdapter(::onUserSelected)
        adapter = listAdapter
        layoutManager = LinearLayoutManager(requireContext())
        addItemDecoration(
            DividerItemDecoration(context, (layoutManager as LinearLayoutManager).orientation)
        )
    }

    private fun onUserSelected(presentationItemId: Int){
        viewModel.onMultipleSelectUserPresentationClick(presentationItemId)
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
            fragmentmultipleselectrecyclerlistFirstName.text = it.firstName
            fragmentmultipleselectrecyclerlistLastName.text = it.lastName
            fragmentmultipleselectrecyclerlistCity.text = it.city
            fragmentmultipleselectrecyclerlistCountry.text = it.country
            fragmentmultipleselectrecyclerlistEmail.text = it.email
            fragmentmultipleselectrecyclerlistMotto.text = it.motto
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
