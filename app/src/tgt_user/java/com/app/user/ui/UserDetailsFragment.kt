package com.app.user.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

import com.app.user.core.db.UserData

import com.app.user.R
import com.app.user.databinding.FragmentUserDetailsBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {
    private val binding by lazy { FragmentUserDetailsBinding.inflate(layoutInflater) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = binding.root

    override fun onResume() {
        super.onResume()

        val args: UserDetailsFragmentArgs by navArgs()
        val user = args.user

        setInfoView(user)
    }

    private fun setInfoView(user: UserData) {
        with(binding) {
            nameTV.text = user.firstname + " " + user.name
            emailTV.text = getString(R.string.email_info, user.email)
            genderTV.text = getString(R.string.gender_info, user.gender)
            phoneTV.text = getString(R.string.phone_info, user.phone)
            nationalityTV.text = getString(R.string.nationality_info, user.nationality)
            locationTV.text = getString(R.string.location_info, user.location)
            activity?.let {
                Glide.with(it).load(user.picture)
                    .apply(RequestOptions.centerInsideTransform().error(R.drawable.ic_profile))
                    .into(userIV)
            }

            }
        }

}