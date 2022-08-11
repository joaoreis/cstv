package br.com.jxr.cstv.domain.utils

import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.ZonedDateTime
import java.time.chrono.ChronoZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

object DateFormatter {
    fun format(dateStr: String): String {
        val date = ZonedDateTime.parse(dateStr)
        val formattedDay = date.format(DateTimeFormatter.ofPattern("dd.MM"))
        val formattedHours = date.format(DateTimeFormatter.ofPattern("HH:mm"))

        return when {
            date.isToday() -> "Hoje, $formattedHours"
            date.isTomorrow() -> "Amanhã, $formattedHours"
            date.isWithinAWeek() -> "${date.dayOfWeek.toPtBr()} $formattedHours"
            else -> "$formattedDay $formattedHours"
        }
    }
}

fun ZonedDateTime.isToday(): Boolean = this.dayOfYear == LocalDateTime.now().dayOfYear

fun ZonedDateTime.isTomorrow(): Boolean {
    return this.dayOfYear == LocalDateTime.now().plusDays(1).dayOfYear
}

private fun ZonedDateTime.isWithinAWeek(): Boolean {
    val tomorrow = ChronoZonedDateTime.from(this).plus(1, ChronoUnit.DAYS)
    val sameDayNextWeek = ChronoZonedDateTime.from(this).plus(7, ChronoUnit.DAYS)
    return this.isAfter(tomorrow) and this.isBefore(sameDayNextWeek)
}

fun DayOfWeek.toPtBr(): String =
    when (this) {
        DayOfWeek.MONDAY -> "Seg"
        DayOfWeek.TUESDAY -> "Ter"
        DayOfWeek.WEDNESDAY -> "Qua"
        DayOfWeek.THURSDAY -> "Qui"
        DayOfWeek.FRIDAY -> "Sex"
        DayOfWeek.SATURDAY -> "Sáb"
        DayOfWeek.SUNDAY -> "Dom"
    }
