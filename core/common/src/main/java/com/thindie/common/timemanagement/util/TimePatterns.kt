package com.thindie.common.timemanagement.util

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class TimePatterns @Inject constructor() {

    fun patternSpecialFormat(): String {
        return "E, dd MMM, yyyy"
    }

    fun patternSimpleDay(): String {
        return "d"
    }

    fun patternCustom(): String {
        return "dd_MMMM_"
    }

    fun patternDay(): String {
        return "EEEE"
    }

    fun patternDayShort(): String {
        return "E"
    }

    fun patternMonthFull(): String {
        return "LLLL"
    }


}