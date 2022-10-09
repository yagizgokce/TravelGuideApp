package com.yagizgokce.travelguideapp.data.remote.repository

import com.yagizgokce.travelguideapp.data.remote.ApiService
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.repository.TravelListRepository
import retrofit2.Response
import javax.inject.Inject

class TravelListRepositoryImp @Inject constructor (private val apiService: ApiService):TravelListRepository {

    override suspend fun getTravelData(category: String): Response<List<AllTravelListModel>> {
        return apiService.getTravelData(category)
    }
}