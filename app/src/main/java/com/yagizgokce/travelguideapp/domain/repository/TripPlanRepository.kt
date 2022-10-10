package com.yagizgokce.travelguideapp.domain.repository

import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.model.TripPlanModel

interface TripPlanRepository {

    suspend fun insertAll(vararg tripPlanModel: TripPlanModel) : List<Long>

    suspend fun getAllPlanData() : List<TripPlanModel>

    suspend fun deleteAll()
}