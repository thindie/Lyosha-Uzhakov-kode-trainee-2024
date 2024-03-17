package com.thindie.coder_profile.presentation.events

sealed interface CoderProfileViewModelEvent {
    data class OnCoderRequest(val id: String): CoderProfileViewModelEvent
}