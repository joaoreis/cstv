package br.com.jxr.cstv.data.remote.mappers

import br.com.jxr.cstv.data.remote.dto.PlayerDto
import br.com.jxr.cstv.domain.model.Player

class PlayerMapper {
    fun map(playerDto: PlayerDto): Player =
        with(playerDto) {
            Player(
                id = id,
                name = name,
                firstName = firstName.orEmpty(),
                lastName = lastName.orEmpty(),
                imageUrl = imageUrl
            )
        }
}
