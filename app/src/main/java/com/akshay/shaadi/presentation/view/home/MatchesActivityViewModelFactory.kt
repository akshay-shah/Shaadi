package com.akshay.shaadi.presentation.view.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.akshay.shaadi.domain.BaseUseCase
import com.akshay.shaadi.domain.getmatches.GetMatchesUseCase

@Suppress("UNCHECKED_CAST")
class MatchesActivityViewModelFactory(val useCase: BaseUseCase<GetMatchesUseCase.Request, GetMatchesUseCase.Response>) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (useCase) {
            is GetMatchesUseCase -> MatchesActivityViewModel(useCase) as T
            else -> throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}