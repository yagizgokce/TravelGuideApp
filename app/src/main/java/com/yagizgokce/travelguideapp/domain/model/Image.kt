package com.yagizgokce.travelguideapp.domain.model

data class Image(
    val altText: Any,
    val height: Int,
    val url: String,
    val width: Int,
    val isHeroImage: Boolean?
)