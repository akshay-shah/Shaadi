package com.akshay.shaadi.domain.getmatches

import com.akshay.shaadi.domain.BaseUseCase
import com.akshay.shaadi.domain.repository.DataRepository

class GetMatchesUseCase(val repository: DataRepository) :
    BaseUseCase<GetMatchesUseCase.Request, GetMatchesUseCase.Response>() {
    override suspend fun executeUseCase(request: Request): Response {
        return repository.getMatches()
    }

    class Request : BaseUseCase.Request {

    }

    class Response(val list: List<Profile>) :
        BaseUseCase.Response {

    }
}