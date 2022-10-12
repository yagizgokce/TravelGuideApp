package com.yagizgokce.travelguideapp.data.remote

import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @GET("AllTravelList")
   suspend fun getTravelData(@Query("category") category: String): Response <List<AllTravelListModel>>

    @GET("AllTravelList")
    suspend fun getBookmarkData(@Query("isBookmark") isBookmark: Boolean): Response <List<AllTravelListModel>>


    @PUT("AllTravelList/{id}")
   suspend fun updateData(@Path("id") id : Int, @Body allTravelListModel: AllTravelListModel) : Response<AllTravelListModel>
}