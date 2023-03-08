package com.app.user.ui.user_list

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.user.core.datasources.UserRepo
import com.app.user.core.db.CountryData
import com.app.user.response.CountryJson
import com.app.user.response.CountryKeys
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class CountryViewModel(private val repository: UserRepo) : ViewModel() {

    private val _state = MutableStateFlow(UsersListState(false))
    val state: StateFlow<UsersListState> = _state

    private var countryData = mutableListOf<CountryKeys>()
    private var countryDBData = mutableListOf<CountryData>()
    init {
        viewModelScope.launch {
            getCountryLocal(repository)
        }
    }

    suspend fun getCountries() = try {
        _state.emit(UsersListState(true))
        val country = repository.getCountries().data

        val itr = country.keys.iterator()
        countryData.clear()
        while (itr.hasNext()) {
            val key = itr.next()
            val value = country[key]
            value?.let { CountryKeys(key, it) }?.let { countryData.add(it) }
        }
        Log.e("CountryData", countryData.toString())
        val countryRegions = mutableListOf<String>()
        val countryCodeName = ArrayList<CountryJson>()
        for (cnData in countryData) {
            countryRegions.add(cnData.mCountry.region)
        }
        val countryRegionSet = HashSet<String>()
        countryRegionSet.addAll(countryRegions)
        countryRegions.clear()
        countryRegions.addAll(countryRegionSet)
        countryDBData.clear()
        for (cRegions in countryRegions){
            countryCodeName.clear()
            for (cnData in countryData) {
                if(cnData.mCountry.region == cRegions) {
                    countryCodeName.add(CountryJson(cnData.mCountry.country, cnData.code))
                }
            }
            countryDBData.add(CountryData(countryCodeName, cRegions))
        }
        repository.deleteAll()
        repository.insertCountries(countryDBData)
        _state.emit(UsersListState(country = countryDBData.toList()))
    }catch (e: UnknownHostException) {
        _state.emit(UsersListState(country = countryDBData.toList()))
    } catch (e: Exception) {
        _state.emit(UsersListState(country = countryDBData.toList()))
    }

    private suspend fun getCountryLocal(repository: UserRepo) {
       /* repository.getCountryFromLocal().collect {
            countryDBData.addAll(it)
        }*/
        countryData.clear()
        countryDBData.clear()
        countryDBData.addAll(repository.getCountryFromLocal())
    }

    suspend fun getData() {
        getCountryLocal(repository)
        _state.emit(UsersListState(country = countryDBData))
    }

    fun verifyAvailableNetwork(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager?.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}
