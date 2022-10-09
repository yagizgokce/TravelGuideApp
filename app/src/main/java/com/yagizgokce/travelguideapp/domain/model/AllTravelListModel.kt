package com.yagizgokce.travelguideapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName

@Entity
@Parcelize
data class AllTravelListModel(
    @ColumnInfo(name = "category")
    @SerializedName("category")
    val category: String,
    @ColumnInfo(name = "city")
    @SerializedName("city")
    val city: String,
    @ColumnInfo(name = "country")
    @SerializedName("country")
    val country: String,
    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String,
    @ColumnInfo(name = "id")
    @SerializedName("id")
    val id: String,
    @ColumnInfo(name = "images")
    @SerializedName("images")
    val images: List<Image>?,
    @ColumnInfo(name = "isBookmark")
    @SerializedName("isBookmark")
    val isBookmark: Boolean,
    @ColumnInfo(name = "title")
    @SerializedName("title")
    val title: String
): Parcelable {
    @PrimaryKey(autoGenerate = true)
    var uuid : Int = 0
}
 class ListTypeConventer{
    @TypeConverter
    fun listToJson(value : List<Image>) : String {
       return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToList(value: String) : List<Image>{
        return Gson().fromJson(value, Array<Image>::class.java).toList()
    }
}