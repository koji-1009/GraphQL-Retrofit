package com.dr1009.app.gr.ui.retrofit

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.dr1009.app.gr.R
import com.dr1009.app.gr.databinding.FragmentDashboardBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RetrofitFragment : Fragment(R.layout.fragment_dashboard) {

    private val retrofitViewModel by viewModels<RetrofitViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentDashboardBinding.bind(view)

        retrofitViewModel.text.observe(viewLifecycleOwner) {
            binding.textDashboard.text = it
        }
    }
}