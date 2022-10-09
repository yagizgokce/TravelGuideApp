package com.yagizgokce.travelguideapp.domain.repository

import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel

interface TravelListRoomRepository {

    suspend fun insertAll(vararg allTravelList: AllTravelListModel) : List<Long>

    suspend fun getAllTravelData() : List<AllTravelListModel>

    suspend fun deleteAll()
}