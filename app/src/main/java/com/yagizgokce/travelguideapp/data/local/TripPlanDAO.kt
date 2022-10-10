package com.yagizgokce.travelguideapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.model.TripPlanModel

@Dao
interface TripPlanDAO {

    @Insert
    suspend fun insertAll(vararg tripPlanModel: TripPlanModel) : List<Long>

    @Query("SELECT * FROM TripPlanModel ")
    suspend fun getAllPlanData() : List<TripPlanModel>


    @Query("DELETE FROM TripPlanModel")
    suspend fun deleteAll()

}