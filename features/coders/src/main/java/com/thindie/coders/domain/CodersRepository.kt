package com.thindie.coders.domain

import com.thindie.model.coders.CoderModel

internal interface CodersRepository {
    suspend fun getCodersList(): Result<List<CoderModel>>
}