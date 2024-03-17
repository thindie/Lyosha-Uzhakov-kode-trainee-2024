package com.thindie.database.di

import android.content.Context
import androidx.room.Room
import com.thindie.database.CodersAppDataBase
import com.thindie.database.DataBaseContract.DB_NAME
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal object DataBaseModule {


    @Provides
    @Singleton
    fun provideDataBase(context: Context): CodersAppDataBase {
        return Room
            .databaseBuilder(
                context = context, klass = CodersAppDataBase::class.java, name = DB_NAME
            )
            .build()
    }
}