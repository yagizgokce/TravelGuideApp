package com.yagizgokce.travelguideapp.presentation.plan.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.R
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.model.TripPlanModel

class PlanRecyclerAdapter(private val tripPlanModel: List<TripPlanModel>)
    :RecyclerView.Adapter<PlanViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlanViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.plan_recycler_row,
            parent,
            false)
        return PlanViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlanViewHolder, position: Int) {
        holder.planBind(tripPlanModel.get(position))
    }

    override fun getItemCount(): Int {
        return tripPlanModel.size
    }
}