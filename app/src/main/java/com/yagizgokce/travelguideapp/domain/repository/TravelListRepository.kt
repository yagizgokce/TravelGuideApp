package com.yagizgokce.travelguideapp.domain.repository

import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import retrofit2.Response

interface TravelListRepository {
    suspend fun getTravelData(category: String): Response<List<AllTravelListModel>>
}