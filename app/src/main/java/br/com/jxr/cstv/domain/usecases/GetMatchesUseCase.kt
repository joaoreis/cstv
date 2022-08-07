package br.com.jxr.cstv.domain.usecases

import br.com.jxr.cstv.data.MatchRepository

class GetMatchesUseCase(
    private val matchRepository: MatchRepository
) {
    operator fun invoke() {
    }
}
