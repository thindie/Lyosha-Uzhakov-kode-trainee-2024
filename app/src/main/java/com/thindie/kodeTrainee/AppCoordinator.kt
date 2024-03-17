package com.thindie.kodeTrainee

import com.thindie.common.coreartifacts.ConnectivityObserver

internal interface AppCoordinator : ConnectivityObserver {
    suspend fun loadingRequest(): Result<Unit>


}