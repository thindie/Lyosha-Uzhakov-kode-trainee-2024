package com.thindie.network

import retrofit2.Response
import retrofit2.http.GET

internal interface ApiService {
    @GET(value = ApiServiceDefaults.get)
    suspend fun getUsers(): Response<List<CodersDto>>
}