package com.thindie.common.timemanagement.di

import com.thindie.common.timemanagement.util.TimePatterns
import dagger.Module
import dagger.Provides
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Named
import javax.inject.Singleton

@Module
internal class DateTimeFormatterModule {


    @Provides
    @Singleton
    @Named("fullDate")
    fun provideSpecialFormatDay(timePattern: TimePatterns, locale: Locale): DateTimeFormatter {
        return DateTimeFormatter.ofPattern(timePattern.dayMonthYear(), locale)
    }

    @Provides
    @Singleton
    @Named("year")
    fun provideDateTimeFormatterDayShort(
        timePattern: TimePatterns,
        locale: Locale,
    ): DateTimeFormatter {
        return DateTimeFormatter.ofPattern(timePattern.year(), locale)
    }

    @Provides
    @Singleton
    @Named("dayMonth")
    fun provideDateTimeFormatterMonthTitle(
        timePattern: TimePatterns,
        locale: Locale,
    ): DateTimeFormatter {
        return DateTimeFormatter.ofPattern(timePattern.dayMonth(), locale)
    }

    @Provides
    @Singleton
    @Named("iso")
    fun provideDateTimeFormatterIso(): DateTimeFormatter {
        return DateTimeFormatter.ISO_DATE_TIME
    }

}