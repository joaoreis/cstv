package br.com.jxr.cstv.domain.usecases

import br.com.jxr.cstv.domain.model.TeamDetails
import br.com.jxr.cstv.domain.repository.TeamRepository

class GetTeamsUseCase(
    private val teamRepository: TeamRepository
) {
    suspend operator fun invoke(teamIds: List<Int>): List<TeamDetails> =
        teamRepository.getTeamsById(teamIds)
}
