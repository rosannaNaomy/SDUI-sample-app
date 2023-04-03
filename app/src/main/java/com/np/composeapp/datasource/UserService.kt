package com.np.composeapp.datasource

import com.np.composeapp.domain.ProfileModel
import retrofit2.Response
import retrofit2.http.GET

private const val USERS_ENDPOINT =
    "c2760c0b88ab114b66ec1cfac2a006fe/raw/4a6334d2bfbfaabf01b90c4ac0a60517438b65d9/users1"
private const val CONFIG_ENDPOINT =
    "0e2e4bf6bbb8fe89e873688a5b45f715/raw/7e223d00ceb522707caa0d499b0af1205791b777/config"

interface UserService {

    @GET(USERS_ENDPOINT)
    suspend fun getUsers(): Response<UserResponse>

    @GET(CONFIG_ENDPOINT)
    suspend fun getConfig(): Response<ProfileResponse>

}