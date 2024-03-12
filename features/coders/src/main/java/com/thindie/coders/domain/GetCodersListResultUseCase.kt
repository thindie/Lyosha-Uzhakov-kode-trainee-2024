package com.thindie.coders.domain

import com.thindie.coders.di.CodersMainScope
import com.thindie.model.Department
import com.thindie.model.coders.CoderModel
import javax.inject.Inject

@CodersMainScope
internal class GetCodersListResultUseCase @Inject constructor() {
    suspend fun get(): Result<List<CoderModel>> {
        return Result.success(
            listOf(
                CoderModel(
                    avatarUrl = "",
                    isAwaitsBirthdayAtCurrentYear = false,
                    yearOfNearestCelebrate = 0,
                    department = Department.DESIGN,
                    firstName = "1",
                    id = "2",
                    lastName = "3",
                    position = "4",
                    userTag = "5"
                )
            )
        )
    }
}