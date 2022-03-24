package com.jgeron.dynamicrecyclerviewmenu.ui.expandableradiomenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jgeron.dynamicrecyclerviewmenu.databinding.FragmentExpandableRadioMenuBinding

class ExpandableRadioMenuFragment : Fragment() {

    private var _binding: FragmentExpandableRadioMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExpandableRadioMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
