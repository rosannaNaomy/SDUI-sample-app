package com.np.composeapp.repo.mapper

import com.np.composeapp.domain.ProfileModel
import com.np.composeapp.domain.UiSection
import com.np.composeapp.domain.User
import com.np.composeapp.domain.UserData

object ProfileMapper {

    fun mapToProfileModel(user: User, profileConfig: List<String>): ProfileModel {
        return ProfileModel(
            data = UserData(
                id = user.id,
                name = user.name,
                about = user.about,
                gender = user.gender,
                school = user.school,
                hobbies = user.hobbies,
                photo = user.photo,
            ),
            uiSections = profileConfig.map { ui ->
                when (ui) {
                    "name" -> UiSection.NameSection(name = user.name)
                    "about" -> UiSection.AboutSection(about = user.about)
                    "gender" -> UiSection.GenderSection(gender = user.gender)
                    "photo" -> UiSection.ImageSection(imageUrl = user.photo)
                    "school" -> UiSection.SchoolSection(school = user.school)
                    "hobbies" -> UiSection.HobbiesSection(hobbies = user.hobbies)
                    else -> throw IllegalArgumentException("Unknown vehicle type: $ui")
                }
            }
        )
    }

    fun mapFromResponseList(
        profileConfig: List<String>,
        users: List<User>
    ): List<ProfileModel>? {
        return users.map { mapToProfileModel(it, profileConfig) }
    }

}