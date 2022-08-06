package br.com.jxr.cstv.data

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe

class MatchRepositoryTest : BehaviorSpec({

    Given("A Match Repository") {
        val repo = MatchRepository(RemoteDataSource(api))
        When("MatchRepository.getMatches() is called") {
            val actual = repo.getMatches()
            Then("actual should contain items") {
                // TODO: learn how to verify this ._.
                actual shouldNotBe null
            }
        }
    }
})
