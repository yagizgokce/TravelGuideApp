package com.yagizgokce.travelguideapp.presentation.guide.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.presentation.search.adapter.NearbyViewHolder

class MightNeedRecyclerAdapter(private val allTravelListModel: List<AllTravelListModel>)
    : RecyclerView.Adapter<MightNeedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MightNeedViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.mightneed_recycler_row,
            parent,
            false)
        return MightNeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: MightNeedViewHolder, position: Int) {
        holder.mightNeedBind(allTravelListModel.get(position))
    }

    override fun getItemCount(): Int {
        return allTravelListModel.size
    }

}