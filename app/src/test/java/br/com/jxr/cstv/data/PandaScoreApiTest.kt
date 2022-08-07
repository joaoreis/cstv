package br.com.jxr.cstv.data

import br.com.jxr.cstv.data.remote.dto.MatchDto
import br.com.jxr.cstv.data.remote.dto.TeamDetailsDto
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.shouldNotBe

internal class PandaScoreApiTest : BehaviorSpec({
    Given("An API object") {
        val api = api
        When("Get matches is called") {
            val result = api.getMatches(
                page = 1,
                pageSize = 10,
                sort = "-$FIELD_STATUS,$FIELD_BEGIN_AT",
                beginAt = "2022-08-02,2023-08-02"
            )
            Then("The API should return a list of Matches") {
                result shouldNotBe emptyList<MatchDto>()
                result.shouldHaveAtLeastSize(10)
            }
        }

        When("Get Teams is called") {
            val result = api.getTeams("130082,131537")
            Then("The API should return a list of Teams") {
                result shouldNotBe emptyList<TeamDetailsDto>()
                result shouldHaveAtLeastSize 2
            }
        }
    }
})
