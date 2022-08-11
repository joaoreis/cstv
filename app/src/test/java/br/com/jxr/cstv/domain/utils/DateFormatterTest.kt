package br.com.jxr.cstv.domain.utils

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import java.time.Instant
import java.time.LocalDate
import java.time.temporal.ChronoUnit

class DateFormatterTest : FunSpec({

    val sampleDate = Instant.parse("2022-08-10T15:00:00Z")
    val dateFormatter = DateFormatter

    test("Check format for Today") {
        val result = dateFormatter.format("$sampleDate")
        val expected = "Hoje, 15:00"
        result shouldBe expected
    }

    test("Check format for Tomorrow") {
        val tomorrow = sampleDate.plus(1, ChronoUnit.DAYS)
        val result = dateFormatter.format("$tomorrow")
        val expected = "Amanhã, 15:00"
        result shouldBe expected
    }

    test("Check format within a Week") {

        val daysList = buildList<LocalDate> {
            for (i in 2..6) {
                sampleDate.plus(i.toLong(), ChronoUnit.DAYS)
            }
        }

        daysList.forAll { date ->
            val result = dateFormatter.format("$date")
            val newDayOfWeek = date.dayOfWeek

            val expected = "${newDayOfWeek.toPtBr()}, 15:00"
            result shouldBe expected
        }
    }

    test("Check format for after this week") {
        val dateAfterThisWeek = sampleDate.plus(15, ChronoUnit.DAYS)
        val result = dateFormatter.format("$dateAfterThisWeek")
        val expected = "25.08 15:00"
        result shouldBe expected
    }
})
