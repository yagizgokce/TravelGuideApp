package com.yagizgokce.travelguideapp.data.remote

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel

@Dao
interface TravelListDAO {

    @Insert
    suspend fun insertAll(vararg allTravelList: AllTravelListModel) : List<Long>

    @Query("SELECT * FROM AllTravelListModel ")
    suspend fun getAllTravelData() : List<AllTravelListModel>


    @Query("DELETE FROM AllTravelListModel")
    suspend fun deleteAll()

}