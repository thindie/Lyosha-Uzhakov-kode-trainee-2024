package com.thindie.common.coreartifacts

import kotlinx.coroutines.flow.Flow


interface ConnectivityObserver {

    fun observe(): Flow<ConnectivityObserver.Status>


    sealed interface Status {
        data object Available : Status
        data object Unavailable : Status
        data object Losing : Status
        data object Lost : Status

        data object Useless: Status
    }

}
