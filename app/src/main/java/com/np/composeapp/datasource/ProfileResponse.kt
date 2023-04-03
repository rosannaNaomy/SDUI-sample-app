package com.np.composeapp.datasource

import com.squareup.moshi.Json

data class ProfileResponse(
    @Json(name = "profile")
    val sectionType: List<String>
)

//data class ProfileConfig(
//    var sectionType: String
//)

//data class ProfileConfig(
//    @Json(name = "name") var name: String,
//    @Json(name = "photo") var photo: String,
//    @Json(name = "gender") var gender: String,
//    @Json(name = "about") var about: String,
//    @Json(name = "school") var school: String,
//    @Json(name = "hobbies") var hobbies: String
//)