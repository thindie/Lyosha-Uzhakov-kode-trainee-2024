package com.thindie.common

object KodeTraineeCommon {
    object RemoteSource {
        const val baseUrl = "https://stoplight.io/mocks/kode-api/trainee-test/331141861/"

        const val timePattern = "yyyy-MM-dd HH:mm"
        const val timePatternAdjustment = " 00:00"
    }

    object FeatureDestinations {
        private const val profile = "profile/"
        object Arguments {
            const val id = "userId"
        }


        const val codersSummary = "coders"
        const val coderProfile = "$profile{${Arguments.id}}"

        fun argumentCoderProfile(givenId: String): String {
           return "$profile$givenId"
        }
    }
}