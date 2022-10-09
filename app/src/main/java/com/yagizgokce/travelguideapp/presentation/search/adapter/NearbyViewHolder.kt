package com.yagizgokce.travelguideapp.presentation.search.adapter

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.databinding.NearbyRecyclerRowBinding
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.presentation.search.ui.SearchFragmentDirections

class NearbyViewHolder(private val nearbyBinding: ViewDataBinding)
    : RecyclerView.ViewHolder(nearbyBinding.root){

        fun nearbyBind(nearbyItem : AllTravelListModel){
            nearbyBinding as NearbyRecyclerRowBinding
            nearbyBinding.apply {
                setVariable(BR.nearbyListItem,nearbyItem)
                nearbyView.setOnClickListener {
                    Navigation.findNavController(it)
                        .navigate(SearchFragmentDirections.actionSearchFragmentToDetailFragment(nearbyItem))
                }
            }
        }



}