package com.yagizgokce.travelguideapp.presentation.guide.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel

class TopPickRecyclerAdapter(private val allTravelListModel: List<AllTravelListModel>)
    :RecyclerView.Adapter<TopPickViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopPickViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.toppick_recycler_row,
            parent,
            false)
        return TopPickViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopPickViewHolder, position: Int) {
        holder.topPickBind(allTravelListModel.get(position))
    }

    override fun getItemCount(): Int {
        return allTravelListModel.size
    }
}