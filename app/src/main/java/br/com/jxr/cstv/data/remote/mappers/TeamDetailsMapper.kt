package br.com.jxr.cstv.data.remote.mappers

import br.com.jxr.cstv.data.remote.dto.TeamDetailsDto
import br.com.jxr.cstv.domain.model.TeamDetails

internal fun TeamDetailsDto.toTeamDetails(): TeamDetails =
    TeamDetails(
        id = id,
        players = players.map { it.toPlayer() }
    )
