package br.com.jxr.cstv.domain.repository

import br.com.jxr.cstv.domain.model.TeamDetails

interface TeamRepository {
    suspend fun getTeamsById(teamIds: List<Int>): List<TeamDetails>
}
