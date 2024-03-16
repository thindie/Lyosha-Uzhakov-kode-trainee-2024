package com.thindie.database.di

import com.thindie.database.CodersAppDataBase
import com.thindie.database.CodersDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class DaoModule {
    @Provides
    @Singleton
    fun bindDao(dataBase: CodersAppDataBase): CodersDao {
        return dataBase.getInstance()
    }


}
