package com.thindie.database

interface LocalSourceAdapter {

    suspend fun <R> getCodersModelList(mapper: (LocalSourceModel) -> R): Result<List<R>>

    suspend fun <R> getCoderById(id: String, mapper: (LocalSourceModel) -> R): Result<R>

    suspend fun storeCoders(list: List<LocalSourceModel>)
}