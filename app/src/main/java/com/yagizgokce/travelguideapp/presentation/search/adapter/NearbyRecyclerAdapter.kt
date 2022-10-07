package com.yagizgokce.travelguideapp.presentation.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel

class NearbyRecyclerAdapter(private val allTravelListModel: List<AllTravelListModel>)
    : RecyclerView.Adapter<NearbyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NearbyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.nearby_recycler_row,
            parent,
            false)
        return NearbyViewHolder(view)
    }

    override fun onBindViewHolder(holder: NearbyViewHolder, position: Int) {
        holder.nearbyBind(allTravelListModel.get(position))
    }

    override fun getItemCount(): Int {
        return allTravelListModel.size
    }
}