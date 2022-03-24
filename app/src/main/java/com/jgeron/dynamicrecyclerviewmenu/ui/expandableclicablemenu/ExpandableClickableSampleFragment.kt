package com.jgeron.dynamicrecyclerviewmenu.ui.expandableclicablemenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.jgeron.dynamicrecyclerviewmenu.databinding.FragmentExpandableClickableSampleBinding
import com.jgeron.dynamicrecyclerviewmenu.ui.model.UserPresentation
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@WithFragmentBindings
@AndroidEntryPoint
class ExpandableClickableSampleFragment : Fragment() {

    private var _binding: FragmentExpandableClickableSampleBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ExpandableClickableSampleViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExpandableClickableSampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchOneThousandUsers()
        observeState()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeState(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collectLatest { state ->
                bindUserPresentationElements(state.userPresentationsList)
                bindError(state.error)
            }
        }
    }

    private fun bindUserPresentationElements(userPresentationElements: List<UserPresentation>){

    }

    private fun bindError(error: Throwable?){
        if (error != null){
            Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
        }
    }
}