package com.yagizgokce.travelguideapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class AllTravelListModel(
    @SerializedName("category")
    val category: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<Image>?,
    @SerializedName("isBookmark")
    val isBookmark: Boolean,
    @SerializedName("title")
    val title: String
): Parcelable