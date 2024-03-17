package com.thindie.coders.data

import com.thindie.coders.di.CodersMainScope
import com.thindie.coders.domain.CodersRepository
import com.thindie.common.KodeTraineeCommon
import com.thindie.common.timemanagement.TimeOperator
import com.thindie.database.LocalSourceAdapter
import com.thindie.design_system.formatting.KodeTraineeTimePatterns
import com.thindie.model.CoderDepartmentValidator
import com.thindie.model.coders.CoderModel
import javax.inject.Inject

@CodersMainScope
internal class CodersRepositoryImpl @Inject constructor(
    private val remoteSourceAdapter: LocalSourceAdapter,
    private val timeOperator: TimeOperator,
) :
    CodersRepository {
    override suspend fun getCodersList(): Result<List<CoderModel>> {
        return remoteSourceAdapter
            .getCodersModelList { model ->

                val coderBirthDayLocalDateTime = timeOperator.getCurrentFromStringDate(
                    date = model.getModelBirthday()
                        .plus(KodeTraineeCommon.RemoteSource.timePatternAdjustment),
                    pattern = KodeTraineeCommon.RemoteSource.timePattern
                )

                val birthdayInEpochMillis = timeOperator
                    .getMillisFromCurrent(localDateTime = coderBirthDayLocalDateTime)

                val current = timeOperator.getCurrent()

                val isAwaiting = current.dayOfYear < coderBirthDayLocalDateTime.dayOfYear

                CoderModel(
                    avatarUrl = model.getModelAvatarLink(),
                    isAwaitsBirthdayAtCurrentYear = isAwaiting,
                    yearOfNearestCelebrate = if (isAwaiting) current.year else 0,
                    department = CoderDepartmentValidator.getOrThrow(model.getModelDepartment()),
                    firstName = model.getModelFirstName(),
                    id = model.getModelId(),
                    lastName = model.getModelLastName(),
                    position = model.getModelPosition(),
                    userTag = model.getModelUserTag(),
                    dayOfYear = coderBirthDayLocalDateTime.dayOfYear,
                    birthday = timeOperator.getCurrent(
                        birthdayInEpochMillis,
                        KodeTraineeTimePatterns.birthday
                    )
                )
            }

    }
}