package com.thindie.coders.data

import com.thindie.coders.di.CodersMainScope
import com.thindie.coders.domain.CodersRepository
import com.thindie.model.CoderDepartmentValidator
import com.thindie.model.coders.CoderModel
import com.thindie.network.RemoteSourceAdapter
import javax.inject.Inject

@CodersMainScope
internal class CodersRepositoryImpl @Inject constructor(private val remoteSourceAdapter: RemoteSourceAdapter) :
    CodersRepository {
    override suspend fun getCodersList(): Result<List<CoderModel>> {
        return remoteSourceAdapter
            .getCodersDtoList {
                CoderModel(
                    avatarUrl = it.getDtoAvatarLink(),
                    isAwaitsBirthdayAtCurrentYear = false,
                    yearOfNearestCelebrate = 0,
                    department = CoderDepartmentValidator.getOrThrow(it.getDtoDepartment()),
                    firstName = it.getDtoFirstName(),
                    id = it.getDtoId(),
                    lastName = it.getDtoLastName(),
                    position = it.getDtoPosition(),
                    userTag = it.getDtoUserTag()
                )
            }

    }
}