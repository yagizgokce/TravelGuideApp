package com.yagizgokce.travelguideapp.data.remote

import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("AllTravelList")
   suspend fun getTravelData(@Query("category") category: String): Response <List<AllTravelListModel>>
}