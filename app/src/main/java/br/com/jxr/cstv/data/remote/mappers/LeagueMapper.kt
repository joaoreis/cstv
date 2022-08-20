package br.com.jxr.cstv.data.remote.mappers

import br.com.jxr.cstv.data.remote.dto.LeagueDto
import br.com.jxr.cstv.domain.model.League

internal fun LeagueDto?.toLeague() = League(
    this?.name.orEmpty(),
    this?.imageUrl.orEmpty()
)
