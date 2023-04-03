package com.np.composeapp.domain

data class ProfileModel(
    val data: UserData,
    val uiSections: List<UiSection>
)

data class UserData(
    val id: Int,
    val name: String,
    val gender: String,
    val about: String?,
    val photo: String?,
    val school: String?,
    val hobbies: List<String>?
)

sealed class UiSection {
    data class NameSection(val name: String) : UiSection()
    data class AboutSection(val about: String?) : UiSection()
    data class GenderSection(val gender: String?) : UiSection()
    data class SchoolSection(val school: String?) : UiSection()
    data class HobbiesSection(val hobbies: List<String>?) : UiSection()
    data class ImageSection(val imageUrl: String?) : UiSection()
}