package com.yagizgokce.travelguideapp.presentation.plan.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.android.material.tabs.TabLayoutMediator
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.databinding.FragmentTripPlanBinding
import com.yagizgokce.travelguideapp.presentation.plan.adapter.ViewPageAdapter
import dagger.hilt.android.AndroidEntryPoint
val tabArray = arrayOf(
    "Trips",
    "Bookmark"
)
@AndroidEntryPoint
class TripPlanFragment : Fragment() {
    private lateinit var binding: FragmentTripPlanBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_trip_plan,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var tabViewpager = binding.viewPager
        tabViewpager.isSaveEnabled = false
        val tabLayout = binding.tabLayout
        var adapter = ViewPageAdapter(this)

        tabViewpager.adapter = adapter


        TabLayoutMediator(tabLayout, tabViewpager) { tab, position ->
            tab.text = tabArray[position]
        }.attach()
    }


}