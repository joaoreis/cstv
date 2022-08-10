package br.com.jxr.cstv.domain.usecases

import br.com.jxr.cstv.data.remote.repository.MatchRepositoryImpl

class GetMatchesUseCase(
    private val matchRepository: MatchRepositoryImpl
) {
    operator fun invoke() {
    }
}
