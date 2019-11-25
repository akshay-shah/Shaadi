package com.akshay.shaadi.domain.getmatches

data class Model(
    val list: List<Profile> = emptyList()
)

data class Profile(
    val name: String = "",
    val age: String = "",
    val imageUrl: String = ""
)