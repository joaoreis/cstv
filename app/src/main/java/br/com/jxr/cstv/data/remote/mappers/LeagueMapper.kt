package br.com.jxr.cstv.data.remote.mappers

import br.com.jxr.cstv.data.remote.dto.LeagueDto
import br.com.jxr.cstv.domain.model.League

class LeagueMapper {
    fun map(leagueDto: LeagueDto) = League(
        leagueDto.name,
        leagueDto.imageUrl.orEmpty()
    )
}
