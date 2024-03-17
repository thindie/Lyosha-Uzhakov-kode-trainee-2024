package com.thindie.network.remoteresponse

import com.thindie.network.RemoteSourceDto

internal data class Item(
    val avatarUrl: String,
    val birthday: String,
    val department: String,
    val firstName: String,
    val id: String,
    val lastName: String,
    val phone: String,
    val position: String,
    val userTag: String,
) : RemoteSourceDto {
    override fun getDtoAvatarLink() = avatarUrl

    override fun getDtoBirthday() = birthday

    override fun getDtoDepartment() = department

    override fun getDtoFirstName() = firstName

    override fun getDtoId() = id

    override fun getDtoLastName() = lastName

    override fun getDtoPhone() = phone

    override fun getDtoPosition() = position

    override fun getDtoUserTag() = userTag

}