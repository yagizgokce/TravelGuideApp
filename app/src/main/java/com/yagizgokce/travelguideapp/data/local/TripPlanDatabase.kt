package com.yagizgokce.travelguideapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.yagizgokce.travelguideapp.domain.model.TripPlanModel

@Database(entities = [TripPlanModel::class], version = 1)
abstract class TripPlanDatabase : RoomDatabase() {

    abstract fun tripPlanDAO() : TripPlanDAO

    companion object {
        @Volatile
        private var INSTANCE: TripPlanDatabase? = null


        private val lock = Any()

        operator fun invoke(context : Context) = INSTANCE ?: synchronized(lock){
            INSTANCE ?: createDatabase(context).also {
                INSTANCE = it
            }
        }


        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            TripPlanDatabase::class.java,"tripplandb").build()
    }


}