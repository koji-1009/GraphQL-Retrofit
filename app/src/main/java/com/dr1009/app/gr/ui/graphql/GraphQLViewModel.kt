package com.dr1009.app.gr.ui.graphql

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.dr1009.app.gr.RepositoriesQuery
import com.dr1009.app.gr.repository.GraphQLRepository
import kotlinx.coroutines.launch

class GraphQLViewModel @ViewModelInject constructor(
    private val repository: GraphQLRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val list = MutableLiveData<List<RepositoriesQuery.Node>>()

    init {
        viewModelScope.launch {
            val response = repository.repositories()
            list.value = response
        }
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is GraphQL Fragment"
    }
    val text: LiveData<String> = _text
}