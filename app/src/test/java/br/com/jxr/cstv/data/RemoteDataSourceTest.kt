package br.com.jxr.cstv.data

import androidx.paging.PagingSource
import br.com.jxr.cstv.data.remote.dto.MatchDto
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.collections.shouldHaveAtLeastSize
import io.kotest.matchers.types.shouldBeTypeOf

private const val TestLoadSize = 2

class RemoteDataSourceTest : BehaviorSpec({
    Given("A datasource for the Pandascore api") {
        val datasource = MatchRemoteDataSource(api)
        When("load is called a single time") {
            val result = datasource.load(
                PagingSource.LoadParams.Refresh(
                    key = null,
                    loadSize = TestLoadSize,
                    placeholdersEnabled = true
                )
            )
            Then("Should return a Page with matches") {
                result.shouldBeTypeOf<PagingSource.LoadResult.Page<Int, MatchDto>>()
                result.data shouldHaveAtLeastSize 2
            }
        }
    }
})
