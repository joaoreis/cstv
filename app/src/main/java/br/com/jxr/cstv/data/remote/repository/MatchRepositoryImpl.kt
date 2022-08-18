package br.com.jxr.cstv.data.remote.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import br.com.jxr.cstv.data.remote.MatchRemoteDataSource
import br.com.jxr.cstv.data.remote.NETWORK_PAGE_SIZE
import br.com.jxr.cstv.data.remote.mappers.MatchMapper
import br.com.jxr.cstv.domain.model.Match
import br.com.jxr.cstv.domain.repository.MatchRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MatchRepositoryImpl @Inject constructor(
    private val matchDataSource: MatchRemoteDataSource,
    private val matchMapper: MatchMapper
) : MatchRepository {
    override fun getMatches(): Flow<PagingData<Match>> {
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
