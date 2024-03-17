package com.thindie.coder_profile.domain

import com.thindie.model.coder_profile.CoderProfileModel

internal interface CoderProfileRepository {
    suspend fun getCoderProfile(id: String): Result<CoderProfileModel>
}