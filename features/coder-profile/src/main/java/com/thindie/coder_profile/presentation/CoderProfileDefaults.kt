package com.thindie.coder_profile.presentation

import androidx.annotation.StringRes
import com.thindie.design_system.KodeTraineeStrings
import com.thindie.model.RussianAgePostfix

internal object CoderProfileDefaults {
    @StringRes
    fun getRussianAgePostfix(postfix: RussianAgePostfix): Int {
      return  when (postfix){
            RussianAgePostfix.FiveToTen -> KodeTraineeStrings.CoderProfile.ageEnded5_0
            RussianAgePostfix.One -> KodeTraineeStrings.CoderProfile.ageEnded1
            RussianAgePostfix.Stub -> KodeTraineeStrings.CoderProfile.stub
            RussianAgePostfix.TwoToFour -> KodeTraineeStrings.CoderProfile.ageEnded2_4
        }
    }
}