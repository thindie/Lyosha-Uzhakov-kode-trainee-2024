package com.thindie.coder_profile.data

import com.thindie.coder_profile.di.CoderProfileScope
import com.thindie.coder_profile.domain.CoderProfileRepository
import com.thindie.common.KodeTraineeCommon
import com.thindie.common.timemanagement.TimeOperator
import com.thindie.database.LocalSourceAdapter
import com.thindie.model.RussianAgePostfix
import com.thindie.model.coder_profile.CoderProfileModel
import java.time.LocalDateTime
import javax.inject.Inject

@CoderProfileScope
internal class CoderProfileRepositoryImpl @Inject constructor(
    private val adapter: LocalSourceAdapter,
    private val timeOperator: TimeOperator,
) :
    CoderProfileRepository {
    override suspend fun getCoderProfile(id: String): Result<CoderProfileModel> {
        return adapter.getCoderById(id) { model ->
            val age = getAge(model.getModelBirthday(), timeOperator)
            CoderProfileModel(
                avatarUrl = model.getModelAvatarLink(),
                firstName = model.getModelFirstName(),
                id = model.getModelId(),
                lastName = model.getModelLastName(),
                position = model.getModelPosition(),
                userTag = model.getModelUserTag(),
                phoneNumber = model.getModelPhone(),
                age = age,
                formattedBirthdayString = formatBirthday(model.getModelBirthday(), timeOperator),
                russianAgePostfix = getRussianAgeLogicalPostfix(age)

            )
        }
    }

    private fun formatBirthday(dtoBirthday: String, timeOperator: TimeOperator): String {
        val birthDayLocalDateTime = getCoderBirthdayLocalDateTime(dtoBirthday, timeOperator)
        return birthDayLocalDateTime.format(timeOperator.getTimeFormatter().getFullDateFormat())
    }

    private fun getRussianAgeLogicalPostfix(age: Int): RussianAgePostfix {
        require(age > -1 && age < 120)

        if (age in 5 .. 20) return RussianAgePostfix.FiveToTen

        return when (age.toString().last().digitToInt()) {
            0 -> {
                RussianAgePostfix.FiveToTen
            }

            1 -> {
                RussianAgePostfix.One
            }

            in 2..4 -> RussianAgePostfix.TwoToFour
            in 5..9 -> RussianAgePostfix.FiveToTen
            else -> RussianAgePostfix.Stub
        }
    }

    private fun getAge(stringDateRepresent: String, timeOperator: TimeOperator): Int {
        val coderBirthDayLocalDateTime =
            getCoderBirthdayLocalDateTime(stringDateRepresent, timeOperator)

        val coderBirthYear = coderBirthDayLocalDateTime.year

        val currentLocalDateTime = timeOperator.getCurrent()

        val isAlreadyGotOlder =
            coderBirthDayLocalDateTime.dayOfYear < currentLocalDateTime.dayOfYear

        val currentYear = currentLocalDateTime.year



        return if (isAlreadyGotOlder) currentYear - coderBirthYear else currentYear - coderBirthYear - 1
    }

    private fun getCoderBirthdayLocalDateTime(
        stringDateRepresent: String,
        timeOperator: TimeOperator,
    ): LocalDateTime {
        return timeOperator.getCurrentFromStringDate(
            date = stringDateRepresent
                .plus(KodeTraineeCommon.RemoteSource.timePatternAdjustment),
            pattern = KodeTraineeCommon.RemoteSource.timePattern
        )
    }
}