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
                birthday = "", dayOfYear = 0
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
                userTag = "",
                birthday = "", dayOfYear = 0
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
                userTag = "",
                birthday = "", dayOfYear = 0
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
                userTag = "",
                birthday = "", dayOfYear = 0
            ).findCoderByNameAndTag(" vb")
        )
    }
}