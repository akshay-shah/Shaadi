package com.akshay.shaadi.data.model

data class Result(
    val cell: String = "",
    val dob: Dob = Dob(),
    val email: String = "",
    val gender: String = "",
    val id: Id = Id(),
    val location: Location = Location(),
    val login: Login = Login(),
    val name: Name = Name(),
    val nat: String = "",
    val phone: String = "",
    val picture: Picture = Picture(),
    val registered: Registered = Registered()
)