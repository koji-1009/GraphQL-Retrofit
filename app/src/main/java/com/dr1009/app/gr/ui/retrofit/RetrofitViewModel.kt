package com.dr1009.app.gr.ui.retrofit

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.dr1009.app.gr.repository.RetrofitRepository

class RetrofitViewModel @ViewModelInject constructor(
    private val repository: RetrofitRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Retrofit Fragment"
    }
    val text: LiveData<String> = _text
}