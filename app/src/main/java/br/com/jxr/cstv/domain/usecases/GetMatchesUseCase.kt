package br.com.jxr.cstv.domain.usecases

import br.com.jxr.cstv.data.MatchRepository

class GetMatchesUseCase(
    private val matchRepository: MatchRepository,
    private val matchMapper: MatchMapper
) {
    operator fun invoke() {
    }
}
