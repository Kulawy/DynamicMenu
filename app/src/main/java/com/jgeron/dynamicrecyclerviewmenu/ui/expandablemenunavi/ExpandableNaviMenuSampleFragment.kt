package com.jgeron.dynamicrecyclerviewmenu.ui.expandablemenunavi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jgeron.dynamicrecyclerviewmenu.databinding.FragmentExpandableNaviMenuSampleBinding

class ExpandableNaviMenuSampleFragment : Fragment() {

    private var _binding: FragmentExpandableNaviMenuSampleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExpandableNaviMenuSampleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}