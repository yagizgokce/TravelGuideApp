package com.yagizgokce.travelguideapp.presentation.search.adapter

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.databinding.TopdestinationRecyclerRowBinding
import com.yagizgokce.travelguideapp.domain.model.search.TopDestinationItem

class TopDestinationViewHolder(private val topDestinationBinding: ViewDataBinding):
    RecyclerView.ViewHolder (topDestinationBinding.root){

    fun topDestinationBind(topDestinationItem: TopDestinationItem) {
        topDestinationBinding as TopdestinationRecyclerRowBinding
        topDestinationBinding.setVariable(BR.topDestinationItem, topDestinationItem)
    }
}