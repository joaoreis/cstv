package br.com.jxr.cstv.domain.repository

import androidx.paging.PagingData
import br.com.jxr.cstv.domain.model.Match
import kotlinx.coroutines.flow.Flow

interface MatchRepository {
    fun getMatches(): Flow<PagingData<Match>>
}
