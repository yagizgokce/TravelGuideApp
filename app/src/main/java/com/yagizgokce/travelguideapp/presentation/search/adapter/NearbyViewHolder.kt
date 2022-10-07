package com.yagizgokce.travelguideapp.presentation.search.adapter

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.databinding.NearbyRecyclerRowBinding
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel

class NearbyViewHolder(private val nearbyBinding: ViewDataBinding)
    : RecyclerView.ViewHolder(nearbyBinding.root){

        fun nearbyBind(nearbyItem : AllTravelListModel){
            nearbyBinding as NearbyRecyclerRowBinding
            nearbyBinding.setVariable(BR.nearbyListItem,nearbyItem)
        }
}