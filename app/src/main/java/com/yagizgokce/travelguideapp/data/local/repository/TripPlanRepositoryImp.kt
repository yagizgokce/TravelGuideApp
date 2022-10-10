package com.yagizgokce.travelguideapp.data.local.repository

import com.yagizgokce.travelguideapp.data.local.TripPlanDAO
import com.yagizgokce.travelguideapp.domain.model.TripPlanModel
import com.yagizgokce.travelguideapp.domain.repository.TripPlanRepository
import javax.inject.Inject

class TripPlanRepositoryImp @Inject constructor(
    private val tripPlanDAO: TripPlanDAO
) : TripPlanRepository {
    override suspend fun insertAll(vararg tripPlanModel: TripPlanModel): List<Long> {
        return tripPlanDAO.insertAll(*tripPlanModel)
    }

    override suspend fun getAllPlanData(): List<TripPlanModel> {
        return tripPlanDAO.getAllPlanData()
    }

    override suspend fun deleteAll() {
        return tripPlanDAO.deleteAll()
    }
}