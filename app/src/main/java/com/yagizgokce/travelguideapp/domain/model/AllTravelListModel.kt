package com.yagizgokce.travelguideapp.domain.model

data class AllTravelListModel(
    val category: String,
    val city: String,
    val country: String,
    val description: String,
    val id: String,
    val images: List<Image>,
    val isBookmark: Boolean,
    val title: String
)