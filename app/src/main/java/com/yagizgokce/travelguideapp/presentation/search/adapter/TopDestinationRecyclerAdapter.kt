package com.yagizgokce.travelguideapp.presentation.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.domain.model.search.TopDestinationModel

class TopDestinationRecyclerAdapter(private val topDestinationModel: TopDestinationModel):
    RecyclerView.Adapter<TopDestinationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopDestinationViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.topdestination_recycler_row,
            parent,
            false)
        return TopDestinationViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopDestinationViewHolder, position: Int) {
        holder.topDestinationBind(topDestinationModel.items[position])
    }

    override fun getItemCount(): Int {
        return topDestinationModel.items.size
    }
}