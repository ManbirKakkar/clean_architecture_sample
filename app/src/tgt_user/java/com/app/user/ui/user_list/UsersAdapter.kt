package com.app.user.ui.user_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.user.R
import com.app.user.core.db.UserData
import com.app.user.databinding.UserViewItemBinding
import com.app.user.ui.UsersListFragmentDirections
import com.app.user.ui.user_list.UsersAdapter.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class UsersAdapter : ListAdapter<UserData, UserViewHolder>(DiffCallback()) {

    class UserViewHolder(private val viewBinding: UserViewItemBinding) : RecyclerView.ViewHolder(viewBinding.root) {

        private var user: UserData? = null

        init {
            viewBinding.root.setOnClickListener {
                user?.let {
                    val navController = Navigation.findNavController(itemView)
                    val action = UsersListFragmentDirections.actionUserDetailsFragmentToUsersListFragment(it)
                    navController.navigate(action)
                }

            }
        }

        fun bind(userItem: UserData) {
            with(viewBinding) {
                user = userItem
                userName.text = userItem.name
                Glide.with(viewBinding.root.context).load(userItem.picture)
                    .apply(RequestOptions.centerInsideTransform().error(R.drawable.ic_profile))
                    .into(userImage)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = UserViewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DiffCallback : DiffUtil.ItemCallback<UserData>() {
        override fun areItemsTheSame(oldItem: UserData, newItem: UserData): Boolean {
            return (oldItem.id == newItem.id)
        }

        override fun areContentsTheSame(oldItem: UserData, newItem: UserData): Boolean {
            return oldItem == newItem
        }
    }
}