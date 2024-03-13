package com.thindie.coder_profile.data

import com.thindie.coder_profile.di.CoderProfileScope
import com.thindie.coder_profile.domain.CoderProfileRepository
import com.thindie.common.timemanagement.TimeOperator
import com.thindie.model.RussianAgePostfix
import com.thindie.model.coder_profile.CoderProfileModel
import com.thindie.network.RemoteSourceAdapter
import javax.inject.Inject

@CoderProfileScope
internal class CoderProfileRepositoryImpl @Inject constructor(
    private val adapter: RemoteSourceAdapter,
    private val timeOperator: TimeOperator,
) :
    CoderProfileRepository {
    override suspend fun getCoderProfile(id: String): Result<CoderProfileModel> {
        return adapter.getCodersDtoList {
            val age = getAge(it.getDtoBirthday())
            CoderProfileModel(
                avatarUrl = it.getDtoAvatarLink(),
                firstName = it.getDtoFirstName(),
                id = it.getDtoId(),
                lastName = it.getDtoLastName(),
                position = it.getDtoPosition(),
                userTag = it.getDtoUserTag(),
                phoneNumber = it.getDtoPhone(),
                age = age,
                formattedBirthdayString = it.getDtoBirthday(),
                russianAgePostfix = getRussianAgeLogicalPostfix(age)

            )
        }.mapCatching { codersList ->
            codersList.first { coder -> coder.id == id }
        }
    }

    private fun getRussianAgeLogicalPostfix(age: Int): RussianAgePostfix {
        require(age > -1 && age < 120)
        return RussianAgePostfix.Stub
    }

    private fun getAge(stringDateRepresent: String): Int {
        return 23
    }
}