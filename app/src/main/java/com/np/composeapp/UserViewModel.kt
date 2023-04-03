package com.np.composeapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.np.composeapp.domain.ProfileModel
import com.np.composeapp.domain.User
import com.np.composeapp.repo.UserRepository
import kotlinx.coroutines.launch

class UserViewModel: ViewModel() {


//    private val _userList = MutableLiveData<List<User>>()
//    val userList : LiveData<List<User>>
//        get() = _userList

    private val _profileList = MutableLiveData<List<ProfileModel>>()
    val profileList : LiveData<List<ProfileModel>>
        get() = _profileList

    private val repo = UserRepository()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            _profileList.value = repo.getData()
        }
    }

}