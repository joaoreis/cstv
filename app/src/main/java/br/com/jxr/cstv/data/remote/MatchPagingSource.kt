package br.com.jxr.cstv.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.jxr.cstv.data.remote.dto.MatchDto
import java.io.IOException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import retrofit2.HttpException

private const val INITIAL_PAGE = 1
const val FIELD_STATUS = "status"
const val FIELD_BEGIN_AT = "begin_at"

class MatchPagingSource @Inject constructor(
    private val api: PandaScoreApi
) : PagingSource<Int, MatchDto>() {

    override fun getRefreshKey(state: PagingState<Int, MatchDto>): Int? {
        return state.anchorPosition?.let { position ->
            val page = state.closestPageToPosition(position)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MatchDto> {
        val page = params.key ?: INITIAL_PAGE

        return try {
            val matches = getMatchesFromApi(page, params)
            returnPagedLoadResult(page, matches)
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    private suspend fun getMatchesFromApi(
        page: Int,
        params: LoadParams<Int>
    ): List<MatchDto> {
        return api.getMatches(
            page = page,
            pageSize = params.loadSize,
            sort = "-$FIELD_STATUS,$FIELD_BEGIN_AT",
            beginAt = getFormattedDateRange()
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
        matches: List<MatchDto>
    ) = LoadResult.Page(
        data = matches,
        prevKey = if (page == INITIAL_PAGE) null else page - 1,
        nextKey = if (matches.isEmpty()) null else page + 1
    )
}
