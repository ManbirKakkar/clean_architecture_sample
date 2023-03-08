package com.app.user.core.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.app.user.response.CountryJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class CountryConverter {

  @TypeConverter
  fun fromSource(countryJson: ArrayList<CountryJson>): String? {
    if (countryJson == null) {
      return null
    }
    val gson = Gson()
    val type = object : TypeToken<ArrayList<CountryJson>?>() {}.type
    return gson.toJson(countryJson, type)
  }

  @TypeConverter
  fun toSource(countryJson: String?): ArrayList<CountryJson>? {
    if (countryJson == null) {
      return null
    }
    val gson = Gson()
    val type = object : TypeToken<ArrayList<CountryJson?>>() {}.type
    return gson.fromJson(countryJson, type)
  }

}