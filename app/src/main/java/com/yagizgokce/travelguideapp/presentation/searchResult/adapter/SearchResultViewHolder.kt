package com.yagizgokce.travelguideapp.presentation.searchResult.adapter

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.databinding.FragmentSearchResultBinding
import com.yagizgokce.travelguideapp.databinding.NearbyRecyclerRowBinding
import com.yagizgokce.travelguideapp.databinding.SearchResultRowBinding
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.presentation.search.ui.SearchFragmentDirections
import com.yagizgokce.travelguideapp.presentation.searchResult.ui.SearchResultFragmentDirections

class SearchResultViewHolder (
    private val searchResultBinding: ViewDataBinding
)
    : RecyclerView.ViewHolder(searchResultBinding.root){

    fun searchResultBind(resulItem : AllTravelListModel){
        searchResultBinding as SearchResultRowBinding
        searchResultBinding.apply {
            setVariable(BR.searchResult,resulItem)

            searchResultView.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(SearchResultFragmentDirections.actionSearchResultFragmentToDetailFragment(resulItem))
            }


        }
    }



}