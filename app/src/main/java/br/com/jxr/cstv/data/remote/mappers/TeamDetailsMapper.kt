package br.com.jxr.cstv.data.remote.mappers

import br.com.jxr.cstv.data.remote.dto.TeamDetailsDto
import br.com.jxr.cstv.domain.model.TeamDetails
import javax.inject.Inject

class TeamDetailsMapper @Inject constructor(
    private val playerMapper: PlayerMapper
) {
    fun map(teamDetailsDto: TeamDetailsDto): TeamDetails =
        TeamDetails(
            id = teamDetailsDto.id,
            players = teamDetailsDto.players.map { playerMapper.map(it) }
        )
}
