package com.yagizgokce.travelguideapp.presentation.searchResult.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.databinding.FragmentSearchResultBinding
import com.yagizgokce.travelguideapp.presentation.searchResult.adapter.SearchResultAdapter
import com.yagizgokce.travelguideapp.presentation.searchResult.viewmodel.SearchResultViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchResultFragment : Fragment() {
    private lateinit var binding: FragmentSearchResultBinding
    private val searchViewModel : SearchResultViewModel by viewModels()
    private val navArgs: SearchResultFragmentArgs? by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search_result,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        binding.backButton.setOnClickListener{
            back()
        }
    }

    private fun init(){
        navArgs?.let{
            getSearch(it.searchTerm)
        }

    }

    fun back(){
        findNavController().popBackStack()
    }

    private fun getSearch(term : String){
        searchViewModel.getSearch(term).observe(viewLifecycleOwner, Observer {searchData ->
            val searchRecyclerAdapter = SearchResultAdapter(searchData)
            val gridLayoutManager = GridLayoutManager(context,1)
            binding.apply {
                searchRecycler.layoutManager = gridLayoutManager
                searchRecycler.adapter = searchRecyclerAdapter
            }

        })

    }
}