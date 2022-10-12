package com.yagizgokce.travelguideapp.presentation.guide.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation

import com.yagizgokce.travelguideapp.databinding.ToppickRecyclerRowBinding
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.presentation.guide.ui.GuideFragmentDirections
import com.yagizgokce.travelguideapp.presentation.plan.ui.TripPlanFragmentDirections

class TopPickViewHolder(private val topPickBinding: ViewDataBinding)
    : RecyclerView.ViewHolder(topPickBinding.root) {

        fun topPickBind(topPickItem : AllTravelListModel){
            topPickBinding as ToppickRecyclerRowBinding
            topPickBinding.apply {
                setVariable(BR.topPickData,topPickItem)
                topPickImage.setOnClickListener {
                    Navigation.findNavController(it)
                        .navigate(GuideFragmentDirections.actionGuideFragmentToDetailFragment(topPickItem))
                }
            }
        }
}