package com.thindie.coder_profile.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thindie.coder_profile.di.CoderProfileScope
import com.thindie.coder_profile.domain.CoderProfileRepository
import com.thindie.coder_profile.presentation.events.CoderProfileViewModelEvent
import com.thindie.coder_profile.presentation.state.CoderProfileScreenState
import com.thindie.common.coreartifacts.ViewStateHolder
import com.thindie.common.coreartifacts.error
import com.thindie.common.coreartifacts.loading
import com.thindie.common.coreartifacts.requestResultAndParse
import com.thindie.common.coreartifacts.subscribeControlledStateFlow
import com.thindie.common.coreartifacts.success
import com.thindie.model.NotExpectedSideEffectInside
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@CoderProfileScope
internal class CoderProfileScreenViewModel @Inject constructor(private val coderProfileRepository: CoderProfileRepository) :
    ViewModel(), ViewStateHolder<CoderProfileScreenState> {

    private val _state = MutableStateFlow(CoderProfileScreenState.getDefault())
    override val state: StateFlow<CoderProfileScreenState> =
        _state.subscribeControlledStateFlow(viewModelScope)


    override fun onError() {
        _state.error()
    }

    override fun onLoading() {
        _state.loading()
    }

    fun onEvent(event: CoderProfileViewModelEvent) {
        when (event) {
            is CoderProfileViewModelEvent.OnCoderRequest -> {
                @NotExpectedSideEffectInside("Encapsulated current VM state management")
                requestResultAndParse(request = { coderProfileRepository.getCoderProfile(event.id) }) { coderProfile ->
                    _state.success()
                    _state.update {
                        it.copy(coderProfile = coderProfile)
                    }
                }
            }
        }
    }

}