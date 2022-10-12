package com.yagizgokce.travelguideapp.presentation.searchResult.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.presentation.search.adapter.NearbyViewHolder

class SearchResultAdapter(
    private val allTravelListModel: List<AllTravelListModel>)

    : RecyclerView.Adapter<SearchResultViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.search_result_row,
            parent,
            false)
        return SearchResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchResultViewHolder, position: Int) {
        holder.searchResultBind(allTravelListModel.get(position))
    }

    override fun getItemCount(): Int {
        return allTravelListModel.size
    }

}