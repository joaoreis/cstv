package br.com.jxr.cstv.domain.usecases

import br.com.jxr.cstv.data.remote.repository.MatchRepositoryImpl
import javax.inject.Inject

class GetMatchesUseCase @Inject constructor(
    private val matchRepository: MatchRepositoryImpl
) {
    operator fun invoke() = matchRepository.getMatches()
}
