package com.np.composeapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.np.composeapp.UserViewModel
import com.np.composeapp.domain.ProfileModel
import com.np.composeapp.domain.UiSection
import com.np.composeapp.domain.User


@Composable
fun UserListScreen(
    modifier: Modifier = Modifier,
    userViewModel: UserViewModel = viewModel()
) {
    Column {
        Column(modifier = modifier.fillMaxHeight(10f)) {
            val profileList by userViewModel.profileList.observeAsState()
            profileList?.let { UserList(profileComponents = it) }
        }
    }
}

@Composable
fun SetView(profileComponents: ProfileModel) {
    profileComponents.uiSections.forEach { uiSection ->
        when (uiSection) {
            is UiSection.NameSection -> {
                UserName(
                    profileComponents.data.name
                )
            }
            is UiSection.ImageSection -> {
                UserImage(
                    profileComponents.data.photo
                )
            }
            is UiSection.AboutSection -> {
                UserImage(
                    profileComponents.data.about
                )
            }
            is UiSection.GenderSection -> {
                UserImage(
                    profileComponents.data.gender
                )
            }
            is UiSection.HobbiesSection -> {
                UserHobbies(
                    profileComponents.data.hobbies
                )
            }
            is UiSection.SchoolSection -> {
                UserSchool(
                    profileComponents.data.school
                )
            }
        }
    }
}

@Composable
fun UserList(
    profileComponents: List<ProfileModel>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(12.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(profileComponents) {
            SetView(profileComponents = it)
        }
    }
}


