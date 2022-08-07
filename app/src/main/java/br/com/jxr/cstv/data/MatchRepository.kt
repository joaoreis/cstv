package br.com.jxr.cstv.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import br.com.jxr.cstv.data.remote.api.NETWORK_PAGE_SIZE
import br.com.jxr.cstv.data.remote.mappers.MatchMapper
import br.com.jxr.cstv.domain.model.Match
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MatchRepository @Inject constructor(
    private val matchDataSource: MatchRemoteDataSource,
    private val matchMapper: MatchMapper
) {
    fun getMatches(): Flow<PagingData<Match>> {
        val pagingConfig = PagingConfig(
            pageSize = NETWORK_PAGE_SIZE,
            enablePlaceholders = false
        )

        return Pager(
            config = pagingConfig,
            pagingSourceFactory = { matchDataSource }
        ).flow.map { pagingData ->
            pagingData.map { matchDto -> matchMapper.map(matchDto) }
        }
    }
}
