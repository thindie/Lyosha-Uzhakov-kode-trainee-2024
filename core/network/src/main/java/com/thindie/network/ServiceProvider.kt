package com.thindie.network


interface ServiceProvider {
    fun getRemoteSourceAdapter(): RemoteSourceAdapter
}