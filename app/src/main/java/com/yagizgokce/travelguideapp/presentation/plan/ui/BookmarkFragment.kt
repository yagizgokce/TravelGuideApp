package com.yagizgokce.travelguideapp.presentation.plan.ui

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
import com.yagizgokce.travelguideapp.databinding.FragmentBookmarkBinding
import com.yagizgokce.travelguideapp.databinding.FragmentSearchBinding
import com.yagizgokce.travelguideapp.presentation.plan.adapter.BookmarkRecyclerAdapter
import com.yagizgokce.travelguideapp.presentation.plan.viewmodel.BookmarkViewModel
import com.yagizgokce.travelguideapp.presentation.plan.viewmodel.TripPlanViewModel
import com.yagizgokce.travelguideapp.presentation.search.adapter.TopDestinationRecyclerAdapter
import com.yagizgokce.travelguideapp.presentation.search.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookmarkFragment : Fragment() {
    private lateinit var binding: FragmentBookmarkBinding
    private val bookmarkViewModel: BookmarkViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_bookmark,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        getBookmarkData()
    }
    private fun getBookmarkData(){
        bookmarkViewModel.getBookmarkData().observe(viewLifecycleOwner, Observer { bookmarkData ->
            val bookmarkRecyclerAdapter = BookmarkRecyclerAdapter (bookmarkData)
            val gridLayoutManager = GridLayoutManager(context,1)
            binding.apply {
                bookmarkRecyclerView.layoutManager = gridLayoutManager
                bookmarkRecyclerView.adapter = bookmarkRecyclerAdapter
            }

        })
    }



}