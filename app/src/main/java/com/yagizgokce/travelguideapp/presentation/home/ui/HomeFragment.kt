package com.yagizgokce.travelguideapp.presentation.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.tabs.TabLayout
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.databinding.FragmentHomeBinding
import com.yagizgokce.travelguideapp.presentation.home.adapter.DealsRecyclerAdapter
import com.yagizgokce.travelguideapp.presentation.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel : HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }
    private fun init() {
        binding.dealsTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> getAllData()
                    1 -> getFlightsData()
                    2 -> getHotelData()
                    3 -> getTransportationData()
                    else ->{
                        getAllData()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> getAllData()
                    1 -> getFlightsData()
                    2 -> getHotelData()
                    3 -> getTransportationData()
                    else ->{
                        getAllData()
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> getAllData()
                    1 -> getFlightsData()
                    2 -> getHotelData()
                    3 -> getTransportationData()
                    else ->{
                        getAllData()
                    }
                }
            }

        }
        )
    }

    private fun getHotelData(){
        println(homeViewModel.getHotels().value)
        homeViewModel.getHotels().observe(viewLifecycleOwner, Observer { hotelsData ->

            val gridLayoutManager = GridLayoutManager(context,1, GridLayoutManager.HORIZONTAL,false)
            val dealsRecyclerAdapter = DealsRecyclerAdapter(hotelsData)

            binding.apply {
                dealsRecyclerView.layoutManager = gridLayoutManager
                dealsRecyclerView.adapter = dealsRecyclerAdapter
            }

        })
    }
    private fun getFlightsData(){
        homeViewModel.getFlights().observe(viewLifecycleOwner, Observer { flightsData ->

            val gridLayoutManager = GridLayoutManager(context,1, GridLayoutManager.HORIZONTAL,false)
            val dealsRecyclerAdapter = DealsRecyclerAdapter(flightsData)

            binding.apply {
                dealsRecyclerView.layoutManager = gridLayoutManager
                dealsRecyclerView.adapter = dealsRecyclerAdapter
            }

        })
    }
    private fun getTransportationData(){
        homeViewModel.getTransportation().observe(viewLifecycleOwner, Observer { transportationData ->

            val gridLayoutManager = GridLayoutManager(context,1, GridLayoutManager.HORIZONTAL,false)
            val dealsRecyclerAdapter = DealsRecyclerAdapter(transportationData)

            binding.apply {
                dealsRecyclerView.layoutManager = gridLayoutManager
                dealsRecyclerView.adapter = dealsRecyclerAdapter
            }

        })
    }

    private fun getAllData(){
        homeViewModel.getAll().observe(viewLifecycleOwner, Observer { allData ->

            val gridLayoutManager = GridLayoutManager(context,1, GridLayoutManager.HORIZONTAL,false)
            val dealsRecyclerAdapter = DealsRecyclerAdapter(allData)

            binding.apply {
                dealsRecyclerView.layoutManager = gridLayoutManager
                dealsRecyclerView.adapter = dealsRecyclerAdapter
            }

        })

    }


}