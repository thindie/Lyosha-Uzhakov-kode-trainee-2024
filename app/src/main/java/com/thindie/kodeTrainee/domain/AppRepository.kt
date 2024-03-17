package com.thindie.kodeTrainee.domain

import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun requestFetch(): Result<Unit>
    fun observeFetchingState(): Flow<Result<Unit>>
}