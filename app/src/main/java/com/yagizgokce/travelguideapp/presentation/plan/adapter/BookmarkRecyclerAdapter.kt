package com.yagizgokce.travelguideapp.presentation.plan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.databinding.BookmarkRecyclerRowBinding
import com.yagizgokce.travelguideapp.databinding.NearbyRecyclerRowBinding
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.presentation.plan.ui.TripPlanFragmentDirections
import com.yagizgokce.travelguideapp.presentation.search.adapter.NearbyViewHolder
import com.yagizgokce.travelguideapp.presentation.search.ui.SearchFragmentDirections

class BookmarkRecyclerAdapter(private val allTravelListModel: List<AllTravelListModel>)
    : RecyclerView.Adapter<BookmarkViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.bookmark_recycler_row,
            parent,
            false)
        return BookmarkViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.nearbyBind(allTravelListModel.get(position))
    }

    override fun getItemCount(): Int {
        return allTravelListModel.size
    }

}