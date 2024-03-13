package com.thindie.model.coder_profile

import com.thindie.model.RussianAgePostfix

data class CoderProfileModel(
    val avatarUrl: String,
    val firstName: String,
    val id: String,
    val lastName: String,
    val position: String,
    val userTag: String,
    val phoneNumber: String,
    val age: Int,
    val formattedBirthdayString: String,
    val russianAgePostfix: RussianAgePostfix,
) {
    fun getFullName() = firstName
        .plus(" ")
        .plus(lastName)

}
