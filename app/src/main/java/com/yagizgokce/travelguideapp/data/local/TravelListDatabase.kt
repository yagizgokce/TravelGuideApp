package com.yagizgokce.travelguideapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.yagizgokce.travelguideapp.data.remote.TravelListDAO
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.model.ListTypeConventer

@Database(entities = arrayOf(AllTravelListModel::class), version = 1)
@TypeConverters(ListTypeConventer::class)
abstract class TravelListDatabase : RoomDatabase() {

    abstract fun travelListDAO() : TravelListDAO

    companion object {
        @Volatile
        private var INSTANCE: TravelListDatabase? = null


        private val lock = Any()

        operator fun invoke(context : Context) = INSTANCE ?: synchronized(lock){
            INSTANCE ?: databaseOlustur(context).also {
                INSTANCE = it
            }
        }


        private fun databaseOlustur(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            TravelListDatabase::class.java,"besindatabase").build()
    }


}