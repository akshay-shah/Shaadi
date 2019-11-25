package com.akshay.shaadi.presentation.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akshay.shaadi.data.repository.Repository

@Suppress("UNCHECKED_CAST")
class MatchesActivityViewModelFactory(val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MatchesActivityViewModel(repository) as T
    }
}