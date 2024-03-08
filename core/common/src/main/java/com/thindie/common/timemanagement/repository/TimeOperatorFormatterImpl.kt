package com.thindie.common.timemanagement.repository

import com.thindie.common.timemanagement.TimeOperatorFormatter
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Named

internal class TimeOperatorFormatterImpl @Inject constructor(
    @Named("iso") private val isoFormat: DateTimeFormatter,
    @Named("day") private val dayFormat: DateTimeFormatter,
    @Named("datePicker") private val isoFormatter: DateTimeFormatter,
    @Named("dayShort") private val dayFormatShort: DateTimeFormatter,
    @Named("daySimpleNumber") private val daySimpleFormat: DateTimeFormatter,
    @Named("monthTitle") private val monthTitleFormat: DateTimeFormatter,
    @Named("dayFull") private val weekDayFullFormat: DateTimeFormatter,
) : TimeOperatorFormatter {

    override fun getDatePickerFormat() = isoFormatter
    override fun getIsoFormat() = isoFormat
    override fun getDayFormat() = dayFormat
    override fun getDayShortFormat() = dayFormatShort

    override fun getSimpleFormat() = daySimpleFormat

    override fun getMonthTitleFormat() = monthTitleFormat

    override fun getWeekDayFullFormat() = weekDayFullFormat
}