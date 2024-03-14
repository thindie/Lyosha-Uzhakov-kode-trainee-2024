package com.thindie.model.coders

import com.thindie.model.NotExpectedSideEffectInside

@NotExpectedSideEffectInside("This Search Engine is non case sensitivity")
fun CoderModel.findCoderByNameAndTag(request: String): Boolean {
    request.ifBlank { return true }
    val adaptedRequest = request.trim().lowercase()
    val pressedCoderInitials = getFullName().plus(userTag).trim().lowercase()
    return pressedCoderInitials.contains(adaptedRequest)
}