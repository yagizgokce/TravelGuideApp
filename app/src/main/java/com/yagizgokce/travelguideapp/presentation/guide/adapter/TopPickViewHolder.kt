package com.yagizgokce.travelguideapp.presentation.guide.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.library.baseAdapters.BR

import com.yagizgokce.travelguideapp.databinding.ToppickRecyclerRowBinding
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel

class TopPickViewHolder(private val topPickBinding: ViewDataBinding)
    : RecyclerView.ViewHolder(topPickBinding.root) {

        fun topPickBind(topPickItem : AllTravelListModel){
            topPickBinding as ToppickRecyclerRowBinding
            topPickBinding.setVariable(BR.topPickData,topPickItem)
        }
}