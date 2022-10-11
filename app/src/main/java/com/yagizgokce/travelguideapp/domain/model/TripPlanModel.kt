package com.yagizgokce.travelguideapp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TripPlanModel(
    @ColumnInfo(name = "city")
    val city: String,
    @ColumnInfo(name = "country")
    val country: String,
    @ColumnInfo(name = "tripDate")
    val tripDate: String
){

    @PrimaryKey(autoGenerate = true)
    var uuid : Int = 0

}
