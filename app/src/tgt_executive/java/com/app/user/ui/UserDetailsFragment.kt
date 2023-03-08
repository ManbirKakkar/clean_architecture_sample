package com.app.user.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

import com.app.user.R
import com.app.user.core.db.CountryData
import com.app.user.databinding.FragmentCountryDetailsBinding
import com.app.user.response.CountryJson

class UserDetailsFragment : Fragment(R.layout.fragment_country_details) {
    private val binding by lazy { FragmentCountryDetailsBinding.inflate(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onResume() {
        super.onResume()

        val args: UserDetailsFragmentArgs by navArgs()
        val user = args.country

        setInfoView(user)
    }

    private fun setInfoView(country: CountryData) {
        with(binding) {
            var countryList: String = ""
            val countryListData = ArrayList<CountryJson>()
            countryListData.addAll(country.countryName!!)
            for (text in countryListData)
                countryList = countryList+"\n"+text.countryName

            binding.countryTV.text= countryList
        }
    }

}