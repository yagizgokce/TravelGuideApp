package com.yagizgokce.travelguideapp.domain.repository

import com.yagizgokce.travelguideapp.domain.model.TripPlanModel
import kotlinx.coroutines.flow.Flow

interface TripPlanRepository {

    suspend fun insertAll(tripPlanModel: TripPlanModel)

    fun getAllPlanData() : Flow<List<TripPlanModel>>

    suspend fun deleteItem(tripPlanModel: TripPlanModel)
}