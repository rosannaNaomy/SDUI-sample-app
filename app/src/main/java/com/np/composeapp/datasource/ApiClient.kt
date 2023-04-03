package com.np.composeapp.datasource

import com.np.composeapp.domain.User

class ApiClient(private val userService: UserService) {

    suspend fun getData(): List<User>? {
        val response = userService.getUsers()
        val list = response.body()

        return list?.users
    }

    suspend fun getConfigData(): List<String>? {
        val response = userService.getConfig()
        val list = response.body()

        return list?.sectionType
    }

}