package com.app.user.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.app.user.R
import com.app.user.databinding.FragmentCountryBinding
import com.app.user.ui.user_list.UsersAdapter
import com.app.user.ui.user_list.CountryViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.coroutines.CoroutineContext

class UsersListFragment : CoroutineScope, Fragment(R.layout.fragment_country) {

    private val binding by lazy { FragmentCountryBinding.inflate(layoutInflater) }
    private val viewModel: CountryViewModel by viewModel()

    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.Main

    private lateinit var usersAdapter: UsersAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

 //       displayedUsers()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        with(binding.recyclerView) {
            usersAdapter = UsersAdapter()
            adapter = usersAdapter
        }
        displayedUsers()
    }

    private fun displayedUsers() {

        launch {
            with(viewModel) {
                if(verifyAvailableNetwork(context!!))
                    getCountries()
                else
                    getData()
                state.collect {
                    if (it.isLoading) {

                    }
                    val users = it.country
                    if (usersAdapter.currentList.isNullOrEmpty()) {
                        usersAdapter.submitList(users.toMutableList())
                    } else {
                        usersAdapter.submitList(usersAdapter.currentList + users.toMutableList())
                    }
                }

            }
        }
    }


}