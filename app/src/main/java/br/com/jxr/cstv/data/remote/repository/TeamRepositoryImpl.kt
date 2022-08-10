package br.com.jxr.cstv.data.remote.repository

import br.com.jxr.cstv.data.remote.TeamsRemoteDataSource
import br.com.jxr.cstv.data.remote.mappers.TeamDetailsMapper
import br.com.jxr.cstv.domain.model.TeamDetails
import br.com.jxr.cstv.domain.repository.TeamRepository
import javax.inject.Inject

class TeamRepositoryImpl @Inject constructor(
    private val teamsDataSource: TeamsRemoteDataSource,
    private val mapper: TeamDetailsMapper
) : TeamRepository {

    override suspend fun getTeamsById(teamIds: List<Int>): List<TeamDetails> {
        return teamsDataSource.getTeamsById(teamIds)
            .map { mapper.map(it) }
    }
}
