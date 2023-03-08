package com.app.user.ui.user_list

import com.app.user.core.db.CountryData
import com.app.user.core.db.UserData

data class UsersListState (
    val isLoading: Boolean = false,
    val users: List<UserData> = emptyList(),
    val country: List<CountryData> = emptyList(),
    val error: String = ""
)