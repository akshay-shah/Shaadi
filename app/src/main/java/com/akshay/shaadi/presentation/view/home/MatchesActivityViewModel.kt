package com.akshay.shaadi.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.akshay.shaadi.domain.getmatches.GetMatchesUseCase
import com.akshay.shaadi.domain.getmatches.Profile
import javax.inject.Inject

class MatchesActivityViewModel @Inject constructor(val useCase: GetMatchesUseCase) : ViewModel(),
    MatchesActivityContract {

    var dataLoading = MutableLiveData<Boolean>()

    override fun getMatches(): LiveData<List<Profile>> {
        dataLoading.value = true
        return liveData {
            emit(useCase.executeUseCase(GetMatchesUseCase.Request()).list)
            dataLoading.value = false
        }
    }
}
