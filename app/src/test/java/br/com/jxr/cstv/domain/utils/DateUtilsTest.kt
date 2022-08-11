package br.com.jxr.cstv.domain.utils

import io.kotest.core.spec.style.FunSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import java.time.ZonedDateTime

class DateUtilsTest : FunSpec({

    test("isToday returns true for today") {
        val today = ZonedDateTime.now()
        today.isToday() shouldBe true
    }

    test("isToday returns false for same calendar day next year") {
        val todayNextYear = ZonedDateTime.now().plusYears(1)
        todayNextYear.isToday() shouldBe false
    }

    test("isToday returns false for tomorrow") {
        val tomorrow = ZonedDateTime.now().plusDays(1)
        tomorrow.isToday() shouldBe false
    }

    test("isToday returns false for yesterday") {
        val yesterday = ZonedDateTime.now().minusDays(1)
        yesterday.isToday() shouldBe false
    }

    test("isTomorrow returns false for today") {
        val today = ZonedDateTime.now()
        today.isTomorrow() shouldBe false
    }

    test("isTomorrow returns true for tomorrow") {
        val tomorrow = ZonedDateTime.now().plusDays(1)
        tomorrow.isTomorrow() shouldBe true
    }

    test("isTomorrow returns false for yesterday") {
        val yesterday = ZonedDateTime.now().minusDays(1)
        yesterday.isTomorrow() shouldBe false
    }

    test("isWithinAWeek returns true for all days from the day after tomorrow until next week") {
        val today = ZonedDateTime.now()
        buildList {
            for (i in 2..6) {
                add(today.plusDays(i.toLong()))
            }
        }.forAll { date ->
            date.isWithinAWeek() shouldBe true
        }
    }

    test("isWithinAWeek returns false for any other days") {
        val today = ZonedDateTime.now()
        today.isWithinAWeek() shouldBe false

        val tomorrow = ZonedDateTime.now().plusDays(1)
        tomorrow.isWithinAWeek() shouldBe false

        val yesterday = ZonedDateTime.now().minusDays(1)
        yesterday.isWithinAWeek() shouldBe false

        var nextWeek = ZonedDateTime.now().plusDays(7)
        nextWeek.isWithinAWeek() shouldBe false

        nextWeek = ZonedDateTime.now().plusDays(15)
        nextWeek.isWithinAWeek() shouldBe false
    }
})
