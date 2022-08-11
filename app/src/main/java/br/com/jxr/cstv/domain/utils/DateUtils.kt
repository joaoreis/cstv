package br.com.jxr.cstv.domain.utils

import java.time.DayOfWeek
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

object DateFormatter {
    fun format(dateStr: String): String {
        val date = ZonedDateTime.parse(dateStr)
        val formattedDay = date.format(DateTimeFormatter.ofPattern("dd.MM"))
        val formattedHours = date.format(DateTimeFormatter.ofPattern("HH:mm"))

        return when {
            date.isToday() -> "Hoje, $formattedHours"
            date.isTomorrow() -> "Amanhã, $formattedHours"
            date.isWithinAWeek() -> "${date.dayOfWeek.toPtBr()}, $formattedHours"
            else -> "$formattedDay $formattedHours"
        }
    }
}

fun ZonedDateTime.isToday(): Boolean = this.toLocalDate() == ZonedDateTime.now().toLocalDate()

fun ZonedDateTime.isTomorrow(): Boolean {
    return this.toLocalDate() == ZonedDateTime.now().plusDays(1).toLocalDate()
}

fun ZonedDateTime.isWithinAWeek(): Boolean {
    val dateAsLocalDate = this.toLocalDate()
    val today = ZonedDateTime.now().toLocalDate()
    val tomorrow = today.plusDays(1)
    val sameDayNextWeek = today.plusDays(7)

    return dateAsLocalDate.isAfter(tomorrow) && dateAsLocalDate.isBefore(sameDayNextWeek)
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
