package br.com.jxr.cstv.data.remote.mappers

import br.com.jxr.cstv.data.remote.dto.OpponentDto
import br.com.jxr.cstv.data.remote.dto.OpponentTypeDto
import br.com.jxr.cstv.domain.model.Team

internal fun OpponentDto.toTeam(): Team =
    when {
        opponent == null || type != OpponentTypeDto.TEAM -> placeHolderTeam

        else -> Team(
            id = opponent.id,
            name = opponent.name,
            imageUrl = opponent.imageUrl.orEmpty()
        )
    }

internal fun List<OpponentDto>?.toTeams(): List<Team> {
    return when {
        this == null -> listOf(placeHolderTeam, placeHolderTeam)
        this.isEmpty() -> listOf(placeHolderTeam, placeHolderTeam)
        this.size == 1 -> map { it.toTeam() } + placeHolderTeam
        else -> map { it.toTeam() }
    }
}

private val placeHolderTeam = Team(
    id = -1,
    name = "TBD",
    imageUrl = ""
)
