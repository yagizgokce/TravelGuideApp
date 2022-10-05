package com.yagizgokce.travelguideapp.data.remote.repository

import com.yagizgokce.travelguideapp.data.remote.ApiService
import com.yagizgokce.travelguideapp.domain.model.search.TopDestinationModel
import com.yagizgokce.travelguideapp.domain.repository.TopDestinationRepository
import retrofit2.Response

class TopDestinationRepositoryImp(private val apiService: ApiService):TopDestinationRepository {

    override suspend fun getTopDestination(category: String): Response<List<TopDestinationModel>> {
        return apiService.getTopDestination(category)
    }
}