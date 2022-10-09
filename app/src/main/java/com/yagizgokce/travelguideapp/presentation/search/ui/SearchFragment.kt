package com.yagizgokce.travelguideapp.presentation.search.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.databinding.FragmentSearchBinding
import com.yagizgokce.travelguideapp.presentation.search.adapter.NearbyRecyclerAdapter
import com.yagizgokce.travelguideapp.presentation.search.adapter.TopDestinationRecyclerAdapter
import com.yagizgokce.travelguideapp.presentation.search.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val searchViewModel : SearchViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        getTopDestinationData()
        getNearByData()
    }
    private fun getTopDestinationData(){
        searchViewModel.getTopDestination().observe(viewLifecycleOwner, Observer { topDestinationData ->
            val topDestinationRecyclerAdapter = TopDestinationRecyclerAdapter(topDestinationData)
            val gridLayoutManager = GridLayoutManager(context,1,GridLayoutManager.HORIZONTAL,false)
            binding.apply {
                topDestinationRecyclerView.layoutManager = gridLayoutManager
                topDestinationRecyclerView.adapter = topDestinationRecyclerAdapter
            }

        })
    }

    private fun getNearByData(){
        searchViewModel.getNearby().observe(viewLifecycleOwner, Observer { nearByData ->
            val nearbyRecyclerAdapter = NearbyRecyclerAdapter(nearByData)
            val gridLayoutManager = GridLayoutManager(context,1)
            binding.apply {
                nearbyRecyclerView.layoutManager = gridLayoutManager
                nearbyRecyclerView.adapter = nearbyRecyclerAdapter
            }
        })
    }


}