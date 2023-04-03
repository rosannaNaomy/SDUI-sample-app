package com.np.composeapp.domain

import com.squareup.moshi.Json

data class User(
    val id: Int,
    val name: String,
    val gender: String,
    val about: String?,
    val photo: String?,
    val school: String?,
    val hobbies: List<String>?
)