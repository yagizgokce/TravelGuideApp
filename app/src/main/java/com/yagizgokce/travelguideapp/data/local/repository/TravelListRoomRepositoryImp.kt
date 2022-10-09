package com.yagizgokce.travelguideapp.data.local.repository

import com.yagizgokce.travelguideapp.data.remote.TravelListDAO
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.repository.TravelListRoomRepository
import javax.inject.Inject

class TravelListRoomRepositoryImp @Inject constructor(
    private val travelListDAO: TravelListDAO
) : TravelListRoomRepository {
    override suspend fun insertAll(vararg allTravelList: AllTravelListModel): List<Long> {
        return travelListDAO.insertAll(*allTravelList)
    }

    override suspend fun getAllTravelData(): List<AllTravelListModel> {
        return travelListDAO.getAllTravelData()
    }

    override suspend fun deleteAll() {
        return travelListDAO.deleteAll()
    }
}