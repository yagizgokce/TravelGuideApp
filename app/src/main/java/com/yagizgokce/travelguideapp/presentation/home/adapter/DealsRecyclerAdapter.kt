package com.yagizgokce.travelguideapp.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel

class DealsRecyclerAdapter(private val allTravelListModel: List<AllTravelListModel>)
    : RecyclerView.Adapter<DealsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DealsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.deals_recycler_row,
            parent,
            false)
        return DealsViewHolder(view)    }

    override fun onBindViewHolder(holder: DealsViewHolder, position: Int) {
        holder.dealsBind(allTravelListModel.get(position))
    }

    override fun getItemCount(): Int {
        return allTravelListModel.size
    }
}