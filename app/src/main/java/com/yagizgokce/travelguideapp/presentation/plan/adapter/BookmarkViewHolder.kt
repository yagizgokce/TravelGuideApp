package com.yagizgokce.travelguideapp.presentation.plan.adapter

import androidx.databinding.ViewDataBinding
import androidx.databinding.library.baseAdapters.BR
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.databinding.BookmarkRecyclerRowBinding
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.presentation.plan.ui.TripPlanFragmentDirections

class BookmarkViewHolder (private val bookmarBinding: ViewDataBinding)
    : RecyclerView.ViewHolder(bookmarBinding.root){

    fun nearbyBind(bookmarkItem : AllTravelListModel){
        bookmarBinding as BookmarkRecyclerRowBinding
        bookmarBinding.apply {
            setVariable(BR.bookmarkItem,bookmarkItem)

            bookmarkImageView.setOnClickListener {
                Navigation.findNavController(it)
                    .navigate(TripPlanFragmentDirections.actionTripPlanFragmentToDetailFragment(bookmarkItem))
            }

        }
    }



}