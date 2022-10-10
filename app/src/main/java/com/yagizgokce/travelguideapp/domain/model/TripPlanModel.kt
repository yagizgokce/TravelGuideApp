package com.yagizgokce.travelguideapp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class TripPlanModel(
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "tripDate")
    val tripDate: String
)
