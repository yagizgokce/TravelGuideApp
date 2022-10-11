package com.yagizgokce.travelguideapp.presentation.plan.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yagizgokce.travelguideapp.BR
import com.yagizgokce.travelguideapp.databinding.PlanRecyclerRowBinding
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.model.TripPlanModel

class PlanViewHolder(private val planBinding: ViewDataBinding)
    : RecyclerView.ViewHolder(planBinding.root){

        fun planBind(planItems : TripPlanModel){
            planBinding as PlanRecyclerRowBinding
            planBinding.setVariable(BR.planItem,planItems)
        }
}