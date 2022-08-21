package br.com.jxr.cstv.domain.usecases

import androidx.paging.PagingData
import br.com.jxr.cstv.data.remote.repository.MatchRepositoryImpl
import br.com.jxr.cstv.domain.model.Match
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow

class GetMatchesUseCase @Inject constructor(
    private val matchRepository: MatchRepositoryImpl
) {
    operator fun invoke(): Flow<PagingData<Match>> = matchRepository.getMatches()
}
