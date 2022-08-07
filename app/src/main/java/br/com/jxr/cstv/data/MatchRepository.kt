package br.com.jxr.cstv.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import br.com.jxr.cstv.data.model.dto.MatchDto
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class MatchRepository @Inject constructor(
    private val dataSource: RemoteDataSource
) {
    fun getMatches(): Flow<PagingData<MatchDto>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { dataSource }
        ).flow
    }
}
