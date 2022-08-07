package br.com.jxr.cstv.data.remote.mappers

import br.com.jxr.cstv.data.remote.dto.OpponentDto
import br.com.jxr.cstv.data.remote.dto.OpponentTypeDto
import br.com.jxr.cstv.domain.model.Team
import javax.inject.Inject

class OpponentMapper @Inject constructor() {
    fun map(opponentDto: OpponentDto): Team? =
        when {
            opponentDto.opponent == null || opponentDto.type != OpponentTypeDto.TEAM -> null
            else -> Team(
                id = opponentDto.opponent.id,
                name = opponentDto.opponent.name,
                imageUrl = opponentDto.opponent.imageUrl.orEmpty()
            )
        }
}
