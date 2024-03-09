package com.thindie.network

interface RemoteSourceDto {

    fun getDtoAvatarLink(): String
    fun getDtoBirthday(): String

    fun getDtoDepartment():String

    fun getDtoFirstName(): String

    fun getDtoId(): String

    fun getDtoLastName(): String

    fun getDtoPhone(): String

    fun getDtoPosition(): String

    fun getDtoUserTag(): String
}