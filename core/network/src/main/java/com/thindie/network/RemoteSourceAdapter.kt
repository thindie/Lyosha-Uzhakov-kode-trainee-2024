package com.thindie.network

interface RemoteSourceAdapter {
    suspend fun<R> getCodersDtoList(mapper: (RemoteSourceDto) -> R): Result<List<R>>
}