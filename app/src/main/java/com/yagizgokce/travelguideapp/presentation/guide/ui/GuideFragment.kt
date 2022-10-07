package com.yagizgokce.travelguideapp.presentation.guide.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.databinding.FragmentGuideBinding
import com.yagizgokce.travelguideapp.presentation.guide.adapter.MightNeedRecyclerAdapter
import com.yagizgokce.travelguideapp.presentation.guide.adapter.TopPickRecyclerAdapter
import com.yagizgokce.travelguideapp.presentation.guide.viewmodel.GuideViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuideFragment : Fragment() {
    private lateinit var binding: FragmentGuideBinding
    private val guideViewModel : GuideViewModel  by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_guide,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {
        getMightNeedData()
        getTopPickData()
    }

    private fun getMightNeedData(){
        guideViewModel.getMightNeed().observe(viewLifecycleOwner, Observer { mightNeedData ->

            val gridLayoutManager = GridLayoutManager(context,1, GridLayoutManager.HORIZONTAL,false)
            val mightNeedRecyclerAdapter = MightNeedRecyclerAdapter(mightNeedData)

            binding.apply {
                mightNeedRecyclerview.layoutManager = gridLayoutManager
                mightNeedRecyclerview.adapter = mightNeedRecyclerAdapter
            }

        })
    }

    private fun getTopPickData(){
        guideViewModel.getTopPick().observe(viewLifecycleOwner, Observer { topPickData ->

            val gridLayoutManager = GridLayoutManager(context,1, GridLayoutManager.HORIZONTAL,false)
            val topPickRecyclerAdapter = TopPickRecyclerAdapter(topPickData)

            binding.apply {
                topPickRecyclerview.layoutManager = gridLayoutManager
                topPickRecyclerview.adapter = topPickRecyclerAdapter
            }
        })
    }


}