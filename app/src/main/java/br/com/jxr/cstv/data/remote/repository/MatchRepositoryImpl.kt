package br.com.jxr.cstv.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import br.com.jxr.cstv.data.remote.MatchPagingSource
import br.com.jxr.cstv.data.remote.NETWORK_PAGE_SIZE
import br.com.jxr.cstv.data.remote.mappers.toMatch
import br.com.jxr.cstv.domain.model.Match
import br.com.jxr.cstv.domain.repository.MatchRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MatchRepositoryImpl @Inject constructor(
    private val matchDataSource: MatchPagingSource
) : MatchRepository {

    private val pagingConfig = PagingConfig(
        pageSize = NETWORK_PAGE_SIZE,
        enablePlaceholders = false
    )

    override fun getMatches(): Flow<PagingData<Match>> {
        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { matchDataSource }
        ).flow.map { pagingData ->
            pagingData.map { it.toMatch() }
        }
    }
}
