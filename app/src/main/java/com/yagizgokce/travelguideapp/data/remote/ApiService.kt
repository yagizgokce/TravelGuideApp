package com.yagizgokce.travelguideapp.data.remote

import com.yagizgokce.travelguideapp.domain.model.search.TopDestinationModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("AllTravelList")
   suspend fun getTopDestination(@Query("category") category: String): Response<List<TopDestinationModel>>
}