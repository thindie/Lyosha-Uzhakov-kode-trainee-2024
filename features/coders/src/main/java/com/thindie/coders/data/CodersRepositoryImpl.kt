package com.thindie.coders.data

import com.thindie.coders.di.CodersMainScope
import com.thindie.coders.domain.CodersRepository
import com.thindie.common.KodeTraineeCommon
import com.thindie.common.timemanagement.TimeOperator
import com.thindie.design_system.formatting.KodeTraineeTimePatterns
import com.thindie.model.CoderDepartmentValidator
import com.thindie.model.coders.CoderModel
import com.thindie.network.RemoteSourceAdapter
import javax.inject.Inject

@CodersMainScope
internal class CodersRepositoryImpl @Inject constructor(
    private val remoteSourceAdapter: RemoteSourceAdapter,
    private val timeOperator: TimeOperator,
) :
    CodersRepository {
    override suspend fun getCodersList(): Result<List<CoderModel>> {
        return remoteSourceAdapter
            .getCodersDtoList { dto ->

                val coderBirthDayLocalDateTime = timeOperator.getCurrentFromStringDate(
                    date = dto.getDtoBirthday()
                        .plus(KodeTraineeCommon.RemoteSource.timePatternAdjustment),
                    pattern = KodeTraineeCommon.RemoteSource.timePattern
                )

                val birthdayInEpochMillis = timeOperator
                    .getMillisFromCurrent(localDateTime = coderBirthDayLocalDateTime)

                val current = timeOperator.getCurrent()

                val isAwaiting = current.dayOfYear < coderBirthDayLocalDateTime.dayOfYear

                CoderModel(
                    avatarUrl = dto.getDtoAvatarLink(),

                    //todo(
                    isAwaitsBirthdayAtCurrentYear = isAwaiting,
                    //todo(
                    yearOfNearestCelebrate = if (isAwaiting) current.year else 0,

                    department = CoderDepartmentValidator.getOrThrow(dto.getDtoDepartment()),
                    firstName = dto.getDtoFirstName(),
                    id = dto.getDtoId(),
                    lastName = dto.getDtoLastName(),
                    position = dto.getDtoPosition(),
                    userTag = dto.getDtoUserTag(),
                    dayOfYear = coderBirthDayLocalDateTime.dayOfYear,
                    birthday = timeOperator.getCurrent(
                        birthdayInEpochMillis,
                        KodeTraineeTimePatterns.birthday
                    )
                )
            }

    }
}