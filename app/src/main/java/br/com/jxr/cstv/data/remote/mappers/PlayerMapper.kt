package br.com.jxr.cstv.data.remote.mappers

import br.com.jxr.cstv.data.remote.dto.PlayerDto
import br.com.jxr.cstv.domain.model.Player

internal fun PlayerDto.toPlayer(): Player =
    Player(
        id = id,
        name = name,
        firstName = firstName.orEmpty(),
        lastName = lastName.orEmpty(),
        imageUrl = imageUrl
    )
