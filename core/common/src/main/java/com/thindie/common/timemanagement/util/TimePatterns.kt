package com.thindie.common.timemanagement.util

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class TimePatterns @Inject constructor() {

    fun dayMonthYear(): String {
        return "dd MMMM yyyy"
    }

    fun year() : String {
        return "yyyy"
    }

    fun dayMonth(): String {
        return "d MMM"
    }

}