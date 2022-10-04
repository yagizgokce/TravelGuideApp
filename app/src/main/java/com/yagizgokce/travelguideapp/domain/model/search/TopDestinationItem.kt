package com.yagizgokce.travelguideapp.domain.model.search

data class TopDestinationItem(
    val title: String?,
    val description: String?,
    val category: String?,
    val country: String?,
    val city: String?,
    val images: List<TopDestinationImages>,
    val isBookmark: Boolean?,
    val id: String?
)
