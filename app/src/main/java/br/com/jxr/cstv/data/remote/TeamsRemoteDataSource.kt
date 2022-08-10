package br.com.jxr.cstv.data.remote

import br.com.jxr.cstv.data.remote.dto.TeamDetailsDto
import javax.inject.Inject

class TeamsRemoteDataSource @Inject constructor(
    private val api: PandaScoreApi
) {
    suspend fun getTeamsById(teamIds: List<Int>): List<TeamDetailsDto> {
        val filterIds = teamIds.joinToString(",")
        return api.getTeams(filterIds)
    }
}
