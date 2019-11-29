package com.akshay.shaadi.data.model

data class Location(
    val city: String = "",
    val coordinates: Coordinates = Coordinates(),
    val country: String = "",
    val postcode: String = "",
    val state: String = "",
    val street: Street = Street(),
    val timezone: Timezone = Timezone()
)