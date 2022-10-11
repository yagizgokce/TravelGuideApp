package com.yagizgokce.travelguideapp.data.local.repository

import com.yagizgokce.travelguideapp.data.local.TripPlanDAO
import com.yagizgokce.travelguideapp.domain.model.TripPlanModel
import com.yagizgokce.travelguideapp.domain.repository.TripPlanRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TripPlanRepositoryImp @Inject constructor(
    private val tripPlanDAO: TripPlanDAO
) : TripPlanRepository {
    override suspend fun insertAll( tripPlanModel: TripPlanModel) {
        return tripPlanDAO.insertAll(tripPlanModel)
    }

    override fun getAllPlanData(): Flow<List<TripPlanModel>> {
        return tripPlanDAO.getAllPlanData()
    }

    override suspend fun deleteItem(tripPlanModel: TripPlanModel) {
        return tripPlanDAO.deleteItem(tripPlanModel)
    }
}