package com.thindie.network

import retrofit2.Retrofit


interface ServiceProvider {
    fun getRetrofit(): Retrofit
}