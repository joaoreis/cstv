package br.com.jxr.cstv.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.jxr.cstv.data.model.Match
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private const val INITIAL_PAGE = 1
const val FIELD_STATUS = "status"
const val FIELD_BEGIN_AT = "begin_at"

class RemoteDataSource(
    private val api: PandaScoreApi
) : PagingSource<Int, Match>() {

    override fun getRefreshKey(state: PagingState<Int, Match>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Match> {
        val page = params.key ?: INITIAL_PAGE
        return try {
            val matches = getMatchesFromApi(page, params)
            returnPagedLoadResult(page, matches)
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }

    private suspend fun getMatchesFromApi(
        page: Int,
        params: LoadParams<Int>
    ): List<Match> {
        return api.getMatches(
            page = page,
            pageSize = params.loadSize,
            sort = "-$FIELD_STATUS,$FIELD_BEGIN_AT",
            beginAt = getFormattedDateRange(),
        )
    }

    private fun getFormattedDateRange(): String {
        val beginAt = LocalDateTime.now()
        val endAt = beginAt.plusYears(1).format(DateTimeFormatter.ISO_LOCAL_DATE)
        // Ex: "2022-08-03, 2023-08-03"
        return "${beginAt.format(DateTimeFormatter.ISO_LOCAL_DATE)}, $endAt"
    }

    private fun returnPagedLoadResult(
        page: Int,
        matches: List<Match>
    ) = LoadResult.Page(
        data = matches,
        prevKey = if (page == INITIAL_PAGE) null else page,
        nextKey = if (matches.isEmpty()) null else page + 1
    )
}