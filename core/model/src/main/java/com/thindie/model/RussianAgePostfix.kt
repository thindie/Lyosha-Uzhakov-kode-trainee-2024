package com.thindie.model

sealed class RussianAgePostfix {
    data object One : RussianAgePostfix()
    data object TwoToFour : RussianAgePostfix()
    data object FiveToTen : RussianAgePostfix()

    data object Stub : RussianAgePostfix()

}