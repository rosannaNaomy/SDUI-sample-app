package com.np.composeapp.repo

import com.np.composeapp.datasource.NetworkLayer
import com.np.composeapp.domain.ProfileModel
import com.np.composeapp.domain.User
import com.np.composeapp.repo.mapper.ProfileMapper

class UserRepository {

    suspend fun getData(): List<ProfileModel>? {
        val userResponseList = NetworkLayer.apiClient.getData()
        val profileConfig = NetworkLayer.apiClient.getConfigData()
        return profileConfig?.let { userResponseList?.let { it1 ->
            ProfileMapper.mapFromResponseList(it,
                it1
            )
        } }
    }

}