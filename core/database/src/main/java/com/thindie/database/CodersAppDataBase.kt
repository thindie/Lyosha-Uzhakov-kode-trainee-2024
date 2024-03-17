package com.thindie.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thindie.database.entities.CoderDbModel
import javax.inject.Singleton

@Singleton
@Database(entities = [CoderDbModel::class], version = 1, exportSchema = false)
internal abstract class CodersAppDataBase : RoomDatabase() {
    abstract fun getInstance(): CodersDao

}
