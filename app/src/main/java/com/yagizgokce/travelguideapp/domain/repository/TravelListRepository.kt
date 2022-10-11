package com.yagizgokce.travelguideapp.domain.repository

import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.presentation.plan.adapter.BookmarkViewHolder
import retrofit2.Response

interface TravelListRepository {
    suspend fun getTravelData(category: String): Response<List<AllTravelListModel>>
    suspend fun getBookmarkData(isBookmark: Boolean): Response<List<AllTravelListModel>>
    suspend fun updateData(id : Int, allTravelListModel: AllTravelListModel) : Response<AllTravelListModel>
}