package com.akshay.shaadi.data.model.matchesmodel

data class MatchesModel(
    val info: Info = Info(),
    val results: List<Result> = listOf()
)