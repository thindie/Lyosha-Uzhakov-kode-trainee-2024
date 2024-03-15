package com.thindie.model.coders

import com.thindie.model.Department

data class CoderModel(
    val avatarUrl: String,
    val isAwaitsBirthdayAtCurrentYear: Boolean,
    val yearOfNearestCelebrate: Int,
    val department: Department,
    val firstName: String,
    val dayOfYear: Int,
    val birthday: String,
    val id: String,
    val lastName: String,
    val position: String,
    val userTag: String,
) {
    fun getFullName() = firstName
        .plus(" ")
        .plus(lastName)

    fun getNearestCelebrationYearOrBlank(): String {
        return if (isAwaitsBirthdayAtCurrentYear) yearOfNearestCelebrate.toString() else CURRENT_YEAR
    }
    companion object {
        private const val CURRENT_YEAR = ""
    }
}
