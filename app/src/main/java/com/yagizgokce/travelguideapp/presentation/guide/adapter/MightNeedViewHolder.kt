package com.yagizgokce.travelguideapp.presentation.guide.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.library.baseAdapters.BR
import com.yagizgokce.travelguideapp.databinding.MightneedRecyclerRowBinding
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel

class MightNeedViewHolder(private val mightNeedBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(mightNeedBinding.root){

        fun mightNeedBind(mightNeedItem : AllTravelListModel){
            mightNeedBinding as MightneedRecyclerRowBinding
            mightNeedBinding.setVariable(BR.mightNeedItem,mightNeedItem)
        }
}