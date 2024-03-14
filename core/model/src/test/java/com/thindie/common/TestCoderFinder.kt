package com.thindie.common

import com.thindie.model.Department
import com.thindie.model.coders.CoderModel
import com.thindie.model.coders.findCoderByNameAndTag
import org.junit.Test

class TestCoderFinder {
    @Test
    fun coderFilter() {
        assert(
            CoderModel(
                avatarUrl = "",
                isAwaitsBirthdayAtCurrentYear = false,
                yearOfNearestCelebrate = 0,
                department = Department.DESIGN,
                firstName = "-1",
                id = "",
                lastName = "-1",
                position = "",
                userTag = "",
                birthdayMillis = 132L,
                birthday = ""
            ).findCoderByNameAndTag("")
        )

        assert(
            CoderModel(
                avatarUrl = "",
                isAwaitsBirthdayAtCurrentYear = false,
                yearOfNearestCelebrate = 0,
                department = Department.DESIGN,
                firstName = "Viva",
                id = "",
                lastName = "Beer",
                position = "",
                userTag = "VB",
                birthdayMillis = 132L,
                birthday = ""
            ).findCoderByNameAndTag("vi")
        )

        assert(
            !CoderModel(
                avatarUrl = "",
                isAwaitsBirthdayAtCurrentYear = false,
                yearOfNearestCelebrate = 0,
                department = Department.DESIGN,
                firstName = "Viva",
                id = "",
                lastName = "Beer",
                position = "",
                userTag = "VB",
                birthdayMillis = 132L,
                birthday = ""
            ).findCoderByNameAndTag("vivi")
        )

        assert(
            CoderModel(
                avatarUrl = "",
                isAwaitsBirthdayAtCurrentYear = false,
                yearOfNearestCelebrate = 0,
                department = Department.DESIGN,
                firstName = "Viva",
                id = "",
                lastName = "Beer",
                position = "",
                userTag = "VB",
                birthdayMillis = 132L,
                birthday = ""
            ).findCoderByNameAndTag(" vb")
        )
    }
}