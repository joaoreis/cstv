package br.com.jxr.cstv.data

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldNotBe

interface DummyApi

internal class ApiBuilderTest : BehaviorSpec({

    Given("A valid Url") {
        Then("Api Builder should return an object") {
            val api = ApiBuilder.buildApi<DummyApi>("https://dummyUrl.com")
            api shouldNotBe null
        }
    }
})
