package com.np.composeapp.datasource

import com.np.composeapp.domain.User
import com.squareup.moshi.Json

data class UserResponse(
    @Json(name = "users")
    val users: List<User>
)