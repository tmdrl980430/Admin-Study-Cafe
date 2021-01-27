package com.example.studycafe.src.main.home

import android.os.Bundle
import android.view.View
import com.example.studycafe.R
import com.example.studycafe.config.BaseFragment
import com.example.studycafe.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::bind, R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}