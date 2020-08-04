package com.dr1009.app.gr.ui.graphql

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.dr1009.app.gr.repository.GraphQLRepository

class GraphQLViewModel @ViewModelInject constructor(
    private val repository: GraphQLRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is GraphQL Fragment"
    }
    val text: LiveData<String> = _text
}