package com.thindie.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.thindie.database.entities.CoderDbModel

@Dao
internal interface CodersDao {
    @Query("SELECT * FROM ${DataBaseContract.codersTable}")
    suspend fun getCoders(): List<CoderDbModel>

    @Upsert
    suspend fun upsertCoders(coders: List<CoderDbModel>)

    @Query("SELECT * FROM ${DataBaseContract.codersTable} WHERE id = :id LIMIT 1")
    suspend fun getCoder(id: String): CoderDbModel


}
