package com.app.user.ui.user_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

import com.app.user.core.db.CountryData
import com.app.user.databinding.CountryViewItemBinding
import com.app.user.ui.UsersListFragmentDirections
import com.app.user.ui.UsersListFragmentDirections.*

class UsersAdapter : ListAdapter<CountryData, UsersAdapter.CountryViewHolder>(DiffCallback()) {

    class CountryViewHolder(private val viewBinding: CountryViewItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        private var user: CountryData? = null

        init {
            viewBinding.root.setOnClickListener {
                user?.let {
                    val navController = Navigation.findNavController(itemView)
                 //   actionCountryDetailsFragmentToCountryListFragment

                    val action = actionCountryDetailsFragment(it)
                    navController.navigate(action)
                }

            }

        }

        fun bind(countryItem: CountryData) {
            with(viewBinding) {
                user = countryItem
                countryRegion.text = countryItem.region
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = CountryViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(view)
    }


    class DiffCallback : DiffUtil.ItemCallback<CountryData>() {
        override fun areItemsTheSame(oldItem: CountryData, newItem: CountryData): Boolean {
            return (oldItem.id == newItem.id)
        }

        override fun areContentsTheSame(oldItem: CountryData, newItem: CountryData): Boolean {
            return oldItem == newItem
        }


    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}