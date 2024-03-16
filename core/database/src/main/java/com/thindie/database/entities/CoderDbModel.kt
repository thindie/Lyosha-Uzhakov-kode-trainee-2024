package com.thindie.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.thindie.database.DataBaseContract.codersTable
import com.thindie.database.LocalSourceModel


@Entity(tableName = codersTable)
internal data class CoderDbModel(

    val avatarUrl: String,
    val birthday: String,
    val department: String,
    val firstName: String,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val lastName: String,
    val phone: String,
    val position: String,
    val userTag: String,
) : LocalSourceModel {
    override fun getModelAvatarLink() = avatarUrl

    override fun getModelBirthday() = birthday

    override fun getModelDepartment() = department

    override fun getModelFirstName() = firstName

    override fun getModelId() = id

    override fun getModelLastName() = lastName

    override fun getModelPhone() = phone

    override fun getModelPosition() = position

    override fun getModelUserTag() = userTag

}
