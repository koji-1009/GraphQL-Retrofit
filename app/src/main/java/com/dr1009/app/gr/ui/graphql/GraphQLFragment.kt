package com.dr1009.app.gr.ui.graphql

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.dr1009.app.gr.R
import com.dr1009.app.gr.databinding.FragmentNotificationsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GraphQLFragment : Fragment(R.layout.fragment_notifications) {

    private val graphQLViewModel by viewModels<GraphQLViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentNotificationsBinding.bind(view)

        graphQLViewModel.text.observe(viewLifecycleOwner) {
            binding.textNotifications.text = it
        }
    }
}