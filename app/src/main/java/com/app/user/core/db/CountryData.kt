package com.app.user.core.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.app.user.response.CountryJson
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "country")
data class CountryData(
    @TypeConverters(CountryConverter::class)
    var countryName: ArrayList<CountryJson>? = null,

    val region: String
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
        get() = field
        set(value) {
            field = value
        }


}
