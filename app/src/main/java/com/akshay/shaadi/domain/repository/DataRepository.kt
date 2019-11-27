package com.akshay.shaadi.domain.repository

import com.akshay.shaadi.domain.getmatches.GetMatchesUseCase

interface DataRepository {
    suspend fun getMatches(): GetMatchesUseCase.Response
}