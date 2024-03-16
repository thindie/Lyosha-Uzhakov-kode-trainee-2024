package com.thindie.database

interface LocalSourceModel {
    fun getModelAvatarLink(): String

    fun getModelBirthday(): String

    fun getModelDepartment(): String

    fun getModelFirstName(): String

    fun getModelId(): String

    fun getModelLastName(): String

    fun getModelPhone(): String

    fun getModelPosition(): String

    fun getModelUserTag(): String
}