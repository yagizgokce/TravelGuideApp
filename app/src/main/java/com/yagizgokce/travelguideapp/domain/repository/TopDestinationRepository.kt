package com.yagizgokce.travelguideapp.domain.repository

import com.yagizgokce.travelguideapp.domain.model.search.TopDestinationModel
import retrofit2.Response

interface TopDestinationRepository {
    suspend fun getTopDestination(category: String): Response<List<TopDestinationModel>>
}