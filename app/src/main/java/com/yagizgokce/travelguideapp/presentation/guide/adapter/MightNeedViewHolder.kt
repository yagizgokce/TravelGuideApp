package com.yagizgokce.travelguideapp.presentation.guide.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import com.yagizgokce.travelguideapp.databinding.MightneedRecyclerRowBinding
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.presentation.guide.ui.GuideFragmentDirections

class MightNeedViewHolder(private val mightNeedBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(mightNeedBinding.root){

        fun mightNeedBind(mightNeedItem : AllTravelListModel){
            mightNeedBinding as MightneedRecyclerRowBinding
            mightNeedBinding.apply {
                setVariable(BR.mightNeedItem,mightNeedItem)
                mightNeedImage.setOnClickListener {
                    Navigation.findNavController(it)
                        .navigate(GuideFragmentDirections.actionGuideFragmentToDetailFragment(mightNeedItem))
                }
            }
        }
}