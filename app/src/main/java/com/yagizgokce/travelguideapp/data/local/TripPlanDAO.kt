package com.yagizgokce.travelguideapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.yagizgokce.travelguideapp.domain.model.TripPlanModel
import kotlinx.coroutines.flow.Flow


@Dao
interface TripPlanDAO {

    @Insert
    suspend fun insertAll(tripPlanModel: TripPlanModel)

    @Query("SELECT * FROM TripPlanModel ")
    fun getAllPlanData() : Flow<List<TripPlanModel>>


    @Delete
    suspend fun deleteItem(tripPlanModel: TripPlanModel)

}