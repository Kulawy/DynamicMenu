package com.jgeron.dynamicrecyclerviewmenu.ui.expandablemenunavi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jgeron.dynamicrecyclerviewmenu.R

class ExpandableNaviMenuSampleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sub_navi_menu_sample, container, false)
    }
}