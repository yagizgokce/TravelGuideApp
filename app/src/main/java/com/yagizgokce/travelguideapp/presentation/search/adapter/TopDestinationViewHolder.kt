package com.yagizgokce.travelguideapp.presentation.search.adapter

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.databinding.TopdestinationRecyclerRowBinding
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.presentation.search.ui.SearchFragmentDirections

class TopDestinationViewHolder(private val topDestinationBinding: ViewDataBinding):
    RecyclerView.ViewHolder (topDestinationBinding.root){

    fun topDestinationBind(topDestinationItem: AllTravelListModel) {
        topDestinationBinding as TopdestinationRecyclerRowBinding

        topDestinationBinding.apply{

            setVariable(BR.allTravelListItem, topDestinationItem)

            topDestView.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(SearchFragmentDirections.actionSearchFragmentToDetailFragment(topDestinationItem))
            }
        }
    }
}