package com.akshay.shaadi.presentation.view.home

import androidx.lifecycle.LiveData
import com.akshay.shaadi.domain.getmatches.Profile

interface MatchesActivityContract {
    fun getMatches() : LiveData<List<Profile>>

}