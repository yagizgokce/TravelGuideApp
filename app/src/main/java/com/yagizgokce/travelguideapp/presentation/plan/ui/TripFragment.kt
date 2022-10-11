package com.yagizgokce.travelguideapp.presentation.plan.ui

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.databinding.FragmentTripBinding
import com.yagizgokce.travelguideapp.presentation.plan.adapter.PlanRecyclerAdapter
import com.yagizgokce.travelguideapp.presentation.plan.viewmodel.TripPlanViewModel
import com.yagizgokce.travelguideapp.presentation.search.adapter.TopDestinationRecyclerAdapter

class TripFragment : Fragment() {
    private lateinit var binding: FragmentTripBinding
    private val tripPlanViewModel : TripPlanViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_trip,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        binding.addbutton.setOnClickListener {
            showDialog()
        }
    }

    private fun init(){
        getTripPlanData()
    }

    private fun getTripPlanData(){
        tripPlanViewModel.getSqlData().observe(viewLifecycleOwner, Observer { tripPlanData ->
            println(tripPlanData)
            val planRecyclerAdapter = PlanRecyclerAdapter(tripPlanData)
            val gridLayoutManager = GridLayoutManager(context,1)
            binding.apply {
                planRecyclerView.layoutManager = gridLayoutManager
                planRecyclerView.adapter = planRecyclerAdapter
            }

        })
    }

    private fun showDialog() {
        val fragmentManager = (activity as FragmentActivity).supportFragmentManager
        val newFragment = AddDialogFragment()
        newFragment.show(fragmentManager, "dialog")
    }


}