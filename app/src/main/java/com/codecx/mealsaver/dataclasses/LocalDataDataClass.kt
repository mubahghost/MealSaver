package com.codecx.mealsaver.dataclasses
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "mealTbl")
data class LocalDataDataClass(
    @ColumnInfo(name = "area")
    var area: String?=null,
    @ColumnInfo(name = "category")
    var category: String?=null,
    @ColumnInfo(name = "ingredient1")
    var ingredient1: String?=null,
    @ColumnInfo(name = "ingredient10")
    var ingredient10: String?=null,
    @ColumnInfo(name = "ingredient2")
    var ingredient2: String?=null,
    @ColumnInfo(name = "ingredient3")
    var ingredient3: String?=null,
    @ColumnInfo(name = "ingredient4")
    var ingredient4: String?=null,
    @ColumnInfo(name = "ingredient5")
    var ingredient5: String?=null,
    @ColumnInfo(name = "ingredient6")
    var ingredient6: String?=null,
    @ColumnInfo(name = "ingredient7")
    var ingredient7: String?=null,
    @ColumnInfo(name = "ingredient8")
    var ingredient8: String?=null,
    @ColumnInfo(name = "ingredient9")
    var ingredient9: String?=null,
    @ColumnInfo(name = "instuctions")
    var instuctions: String?=null,
    @ColumnInfo(name = "meal")
    var meal: String?=null,
    @ColumnInfo(name = "mealThumb")
    var mealThumb: String?=null,
    @ColumnInfo(name = "measure1")
    var measure1: String?=null,
    @ColumnInfo(name = "measure10")
    var measure10: String?=null,
    @ColumnInfo(name = "measure2")
    var measure2: String?=null,
    @ColumnInfo(name = "measure3")
    var measure3: String?=null,
    @ColumnInfo(name = "measure4")
    var measure4: String?=null,
    @ColumnInfo(name = "measure5")
    var measure5: String?=null,
    @ColumnInfo(name = "measure6")
    var measure6: String?=null,
    @ColumnInfo(name = "measure7")
    var measure7: String?=null,
    @ColumnInfo(name = "measure8")
    var measure8: String?=null,
    @ColumnInfo(name = "measure9")
    var measure9: String?=null,
    @ColumnInfo(name = "tags")
    var tags: String?=null,
    @ColumnInfo(name = "Youtube")
    var youtube: String?=null
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id:Int=0
}