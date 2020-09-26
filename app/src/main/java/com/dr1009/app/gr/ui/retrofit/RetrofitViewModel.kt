package com.dr1009.app.gr.ui.retrofit

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.dr1009.app.gr.entity.RepositoryFragment
import com.dr1009.app.gr.repository.RetrofitRepository
import kotlinx.coroutines.launch

class RetrofitViewModel @ViewModelInject constructor(
    private val repository: RetrofitRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val list = MutableLiveData<List<RepositoryFragment>>(emptyList())

    init {
        viewModelScope.launch {
            val response = repository.repositories()
            list.value = response
        }
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is Retrofit Fragment"
    }
    val text: LiveData<String> = _text
}