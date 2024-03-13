package com.thindie.coder_profile.presentation.state

import com.thindie.common.coreartifacts.ViewState
import com.thindie.model.RussianAgePostfix
import com.thindie.model.coder_profile.CoderProfileModel

internal data class CoderProfileScreenState(
    val coderProfile: CoderProfileModel,
    override val isLoading: Boolean,
    override val isError: Boolean,
) : ViewState {
    override fun onError(): ViewState {
        return this.copy(isLoading = false, isError = true)
    }

    override fun onLoading(): ViewState {
        return this.copy(isLoading = true, isError = false)
    }

    override fun onSuccess(): ViewState {
        return this.copy(isLoading = false, isError = false)
    }

    companion object {
        fun getDefault() = CoderProfileScreenState(isLoading = false, isError = false, coderProfile = CoderProfileModel(
            avatarUrl = "",
            firstName = "",
            id = "",
            lastName = "",
            position = "",
            userTag = "",
            phoneNumber = "",
            age = 0,
            russianAgePostfix = RussianAgePostfix.Stub
        )
        )
    }
}