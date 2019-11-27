package com.akshay.shaadi.data

data class Model(
    val list: List<Profile> = emptyList()
)

data class Profile(
    val name: String = "",
    val age: String = "",
    val imageUrl: String = ""
)