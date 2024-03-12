package com.thindie.coders.domain

import com.thindie.coders.di.CodersMainScope
import com.thindie.model.coders.CoderModel
import javax.inject.Inject

@CodersMainScope
internal class GetCodersListResultUseCase @Inject constructor(private val repository: CodersRepository) {
    suspend fun get(): Result<List<CoderModel>> {
        return repository.getCodersList()
    }
}