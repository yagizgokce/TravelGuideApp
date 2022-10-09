package com.yagizgokce.travelguideapp.presentation.home.adapter

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.databinding.DealsRecyclerRowBinding
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.presentation.home.ui.HomeFragmentDirections
import com.yagizgokce.travelguideapp.presentation.search.ui.SearchFragmentDirections

class DealsViewHolder(private val dealsBinding: ViewDataBinding)
    : RecyclerView.ViewHolder(dealsBinding.root) {

        fun dealsBind( dealsItem : AllTravelListModel){
            dealsBinding as DealsRecyclerRowBinding
            dealsBinding.apply {
                setVariable(BR.dealsItem,dealsItem)

                dealsView.setOnClickListener {
                    Navigation.findNavController(it)
                        .navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(dealsItem))
                }
            }
        }
}