package com.akshay.shaadi.domain.repository

import com.akshay.shaadi.domain.getmatches.GetMatchesUseCase
import com.akshay.shaadi.domain.getmatches.Profile

interface DataRepository {
    suspend fun getMatches(): GetMatchesUseCase.Response
    suspend fun updateMatches(list: List<Profile>)
}