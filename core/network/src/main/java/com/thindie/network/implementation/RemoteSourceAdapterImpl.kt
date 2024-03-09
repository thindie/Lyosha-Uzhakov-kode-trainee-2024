package com.thindie.network.implementation

import com.thindie.network.ApiService
import com.thindie.network.RemoteSourceAdapter
import com.thindie.network.RemoteSourceDto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class RemoteSourceAdapterImpl @Inject constructor(private val apiService: ApiService):
    RemoteSourceAdapter {
    override suspend fun <R> getCodersDtoList(mapper: (RemoteSourceDto) -> R): Result<List<R>>{
        return kotlin.runCatching {
         val serviceResponse =   apiService.getUsers()
           if (serviceResponse.isSuccessful && serviceResponse.body() != null){
               serviceResponse.body()!!
                   .items
                   .map(mapper)
           }
            else error("httpCode:  ${serviceResponse.code() }; fetching data is not successful")
        }
    }

}