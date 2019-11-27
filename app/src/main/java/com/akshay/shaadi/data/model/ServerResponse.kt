package com.akshay.shaadi.data.model

data class ServerResponse(
    val info: Info = Info(),
    val results: List<Result> = listOf()
)