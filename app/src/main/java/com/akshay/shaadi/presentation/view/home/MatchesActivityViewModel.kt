package com.akshay.shaadi.presentation.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.akshay.shaadi.data.repository.Repository
import com.akshay.shaadi.domain.getmatches.Profile
import javax.inject.Inject

class MatchesActivityViewModel @Inject constructor(val repository: Repository) : ViewModel(),
    MatchesActivityContract {

    override fun getMatches(): LiveData<List<Profile>> {
        return liveData {
            emit(repository.getMatches().list)
        }
    }
}