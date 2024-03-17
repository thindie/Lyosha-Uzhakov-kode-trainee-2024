package com.thindie.kodeTrainee.data

import com.thindie.common.coreartifacts.ConnectivityObserver
import com.thindie.database.LocalSourceAdapter
import com.thindie.database.LocalSourceModel
import com.thindie.kodeTrainee.AppCoordinator
import com.thindie.network.RemoteSourceAdapter
import com.thindie.network.RemoteSourceDto
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow

@Singleton
internal class AppCoordinatorImpl @Inject constructor(
    private val remoteSource: RemoteSourceAdapter,
    private val localSourceAdapter: LocalSourceAdapter,
    private val connectivityObserver: ConnectivityObserver,
) : AppCoordinator {

    override suspend fun loadingRequest(): Result<Unit> {
        return remoteSource.getCodersDtoList(RemoteSourceDto::toLocalSourceModel)
            .onSuccess { sourceModelList ->
                localSourceAdapter.storeCoders(sourceModelList)
            }
                .mapCatching { }
    }

    override fun observe(): Flow<ConnectivityObserver.Status> =
        connectivityObserver.observe()
}

private fun RemoteSourceDto.toLocalSourceModel(): LocalSourceModel {
    return object : LocalSourceModel {
        override fun getModelAvatarLink(): String {
            return getDtoAvatarLink()
        }

        override fun getModelBirthday(): String {
            return getDtoBirthday()
        }

        override fun getModelDepartment(): String {
            return getDtoDepartment()
        }

        override fun getModelFirstName(): String {
            return getDtoFirstName()
        }

        override fun getModelId(): String {
            return getDtoId()
        }

        override fun getModelLastName(): String {
            return getDtoLastName()
        }

        override fun getModelPhone(): String {
            return getDtoPhone()
        }

        override fun getModelPosition(): String {
            return getDtoPosition()
        }

        override fun getModelUserTag(): String {
            return getDtoUserTag()
        }

    }
}