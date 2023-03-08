package com.app.user.ui.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.user.core.api.toUser
import com.app.user.core.datasources.UserRepo
import com.app.user.core.db.UserData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class UserViewModel(private val repository: UserRepo) : ViewModel() {

    private val _state = MutableStateFlow(UsersListState(false))
    val state: StateFlow<UsersListState> = _state

    init {
        viewModelScope.launch {
            getUsersFromLocal(repository)
        }
    }

    private var userList = mutableListOf<UserData>()

    suspend fun getUsers() {
        try {
            _state.emit(UsersListState(true))
            val users = repository.getApiUsers().results
            val listUsers = mutableListOf<UserData>()
            for (user in users) {
                listUsers.add(user.toUser())
            }
            repository.insertAllUsers(listUsers)
            _state.emit(UsersListState(users = listUsers.toList()))
        } catch (e: Exception) {
            _state.emit(UsersListState(users = userList))
        }

    }

    private suspend fun getUsersFromLocal(repository: UserRepo) {
        repository.getUsersFromLocal().collect {
            userList.addAll(it)
        }

    }

}
