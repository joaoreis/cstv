package br.com.jxr.cstv.domain.utils

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

class DateFormatterTest : FunSpec({

    val sampleDate = ZonedDateTime.now()
    val dateFormatter = DateFormatter
    val dayFormat = DateTimeFormatter.ofPattern("dd.MM")
    val hoursFormat = DateTimeFormatter.ofPattern("HH:mm")

    test("Check format for Today") {
        val result = dateFormatter.format("$sampleDate")
        val expected = "Hoje, ${sampleDate.format(hoursFormat)}"
        result shouldBe expected
    }

    test("Check format for Tomorrow") {
        val tomorrow = sampleDate.plusDays(1)
        val result = dateFormatter.format("$tomorrow")
        val expected = "Amanhã, ${tomorrow.format(hoursFormat)}"
        result shouldBe expected
    }

    test("Check format within a Week") {

        val daysList = buildList<ZonedDateTime> {
            for (i in 2..6) {
                add(ZonedDateTime.from(sampleDate.plusDays(i.toLong())))
            }
        }

        daysList.forAll { date ->
            val result = dateFormatter.format("$date")
            val newDayOfWeek = date.dayOfWeek
            val expected = "${newDayOfWeek.toPtBr()}, ${date.format(hoursFormat)}"
            result shouldBe expected
        }
    }

    test("Check format for after this week") {
        val dateAfterThisWeek = sampleDate.plusDays(15)
        val result = dateFormatter.format("$dateAfterThisWeek")
        val expected = "${dateAfterThisWeek.format(dayFormat)} " +
            dateAfterThisWeek.format(hoursFormat)
        result shouldBe expected
    }
})
