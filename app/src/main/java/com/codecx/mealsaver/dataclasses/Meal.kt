package com.codecx.mealsaver.dataclasses


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "mealTblTwo")
data class Meal(
    @SerializedName("dateModified")
    @ColumnInfo(name = "dateModified")
    var dateModified: Long? = null,
    @ColumnInfo(name = "idMeal")
    @SerializedName("idMeal")
    var idMeal: String? = null,
    @ColumnInfo(name = "strArea")
    @SerializedName("strArea")
    var strArea: String? = null,
    @ColumnInfo(name = "strCategory")
    @SerializedName("strCategory")
    var strCategory: String? = null,
    @ColumnInfo(name = "strCreativeCommonsConfirmed")
    @SerializedName("strCreativeCommonsConfirmed")
    var strCreativeCommonsConfirmed: String? = null,
    @ColumnInfo(name = "strDrinkAlternate")
    @SerializedName("strDrinkAlternate")
    var strDrinkAlternate: String? = null,
    @ColumnInfo(name = "strImageSource")
    @SerializedName("strImageSource")
    var strImageSource: String? = null,
    @ColumnInfo(name = "strIngredient1")
    @SerializedName("strIngredient1")
    var strIngredient1: String? = null,
    @ColumnInfo(name = "strIngredient10")
    @SerializedName("strIngredient10")
    var strIngredient10: String? = null,
    @ColumnInfo(name = "strIngredient11")
    @SerializedName("strIngredient11")
    var strIngredient11: String? = null,
    @ColumnInfo(name = "strIngredient12")
    @SerializedName("strIngredient12")
    var strIngredient12: String? = null,
    @ColumnInfo(name = "strIngredient13")
    @SerializedName("strIngredient13")
    var strIngredient13: String? = null,
    @ColumnInfo(name = "strIngredient14")
    @SerializedName("strIngredient14")
    var strIngredient14: String? = null,
    @ColumnInfo(name = "strIngredient15")
    @SerializedName("strIngredient15")
    var strIngredient15: String? = null,
    @ColumnInfo(name = "strIngredient16")
    @SerializedName("strIngredient16")
    var strIngredient16: String? = null,
    @ColumnInfo(name = "strIngredient17")
    @SerializedName("strIngredient17")
    var strIngredient17: String? = null,
    @ColumnInfo(name = "strIngredient18")
    @SerializedName("strIngredient18")
    var strIngredient18: String? = null,
    @ColumnInfo(name = "strIngredient19")
    @SerializedName("strIngredient19")
    var strIngredient19: String? = null,
    @ColumnInfo(name = "strIngredient2")
    @SerializedName("strIngredient2")
    var strIngredient2: String? = null,
    @ColumnInfo(name = "strIngredient20")
    @SerializedName("strIngredient20")
    var strIngredient20: String? = null,
    @ColumnInfo(name = "strIngredient3")
    @SerializedName("strIngredient3")
    var strIngredient3: String? = null,
    @ColumnInfo(name = "strIngredient4")
    @SerializedName("strIngredient4")
    var strIngredient4: String? = null,
    @ColumnInfo(name = "strIngredient5")
    @SerializedName("strIngredient5")
    var strIngredient5: String? = null,
    @ColumnInfo(name = "strIngredient6")
    @SerializedName("strIngredient6")
    var strIngredient6: String? = null,
    @ColumnInfo(name = "strIngredient7")
    @SerializedName("strIngredient7")
    var strIngredient7: String? = null,
    @ColumnInfo(name = "strIngredient8")
    @SerializedName("strIngredient8")
    var strIngredient8: String? = null,
    @ColumnInfo(name = "strIngredient9")
    @SerializedName("strIngredient9")
    var strIngredient9: String? = null,
    @ColumnInfo(name = "strInstructions")
    @SerializedName("strInstructions")
    var strInstructions: String? = null,
    @ColumnInfo(name = "strMeal")
    @SerializedName("strMeal")
    var strMeal: String? = null,
    @ColumnInfo(name = "strMealThumb")
    @SerializedName("strMealThumb")
    var strMealThumb: String? = null,
    @ColumnInfo(name = "strMeasure1")
    @SerializedName("strMeasure1")
    var strMeasure1: String? = null,
    @ColumnInfo(name = "strMeasure10")
    @SerializedName("strMeasure10")
    var strMeasure10: String? = null,
    @ColumnInfo(name = "strMeasure11")
    @SerializedName("strMeasure11")
    var strMeasure11: String? = null,
    @ColumnInfo(name = "strMeasure12")
    @SerializedName("strMeasure12")
    var strMeasure12: String? = null,
    @ColumnInfo(name = "strMeasure13")
    @SerializedName("strMeasure13")
    var strMeasure13: String? = null,
    @ColumnInfo(name = "strMeasure14")
    @SerializedName("strMeasure14")
    var strMeasure14: String? = null,
    @ColumnInfo(name = "strMeasure15")
    @SerializedName("strMeasure15")
    var strMeasure15: String? = null,
    @ColumnInfo(name = "strMeasure16")
    @SerializedName("strMeasure16")
    var strMeasure16: String? = null,
    @ColumnInfo(name = "strMeasure17")
    @SerializedName("strMeasure17")
    var strMeasure17: String? = null,
    @ColumnInfo(name = "strMeasure18")
    @SerializedName("strMeasure18")
    var strMeasure18: String? = null,
    @ColumnInfo(name = "strMeasure19")
    @SerializedName("strMeasure19")
    var strMeasure19: String? = null,
    @ColumnInfo(name = "strMeasure2")
    @SerializedName("strMeasure2")
    var strMeasure2: String? = null,
    @ColumnInfo(name = "strMeasure20")
    @SerializedName("strMeasure20")
    var strMeasure20: String? = null,
    @ColumnInfo(name = "strMeasure3")
    @SerializedName("strMeasure3")
    var strMeasure3: String? = null,
    @ColumnInfo(name = "strMeasure4")
    @SerializedName("strMeasure4")
    var strMeasure4: String? = null,
    @ColumnInfo(name = "strMeasure5")
    @SerializedName("strMeasure5")
    var strMeasure5: String? = null,
    @ColumnInfo(name = "strMeasure6")
    @SerializedName("strMeasure6")
    var strMeasure6: String? = null,
    @ColumnInfo(name = "strMeasure7")
    @SerializedName("strMeasure7")
    var strMeasure7: String? = null,
    @ColumnInfo(name = "strMeasure8")
    @SerializedName("strMeasure8")
    var strMeasure8: String? = null,
    @ColumnInfo(name = "strMeasure9")
    @SerializedName("strMeasure9")
    var strMeasure9: String? = null,
    @ColumnInfo(name = "strSource")
    @SerializedName("strSource")
    var strSource: String? = null,
    @ColumnInfo(name = "strTags")
    @SerializedName("strTags")
    var strTags: String? = null,
    @ColumnInfo(name = "strYoutube")
    @SerializedName("strYoutube")
    var strYoutube: String? = null
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "mealId")
    var mealId: Int = 0
    override fun toString(): String {
        return "Area=$strArea\nCategory=$strCategory\nDrinkAlternate=$strDrinkAlternate\nImageSource=$strImageSource\nIngredient1=$strIngredient1\nMeal=$strMeal\nMeasure1=$strMeasure1\nSource=$strSource\nTags=$strTags\nYoutube=$strYoutube"
    }


}