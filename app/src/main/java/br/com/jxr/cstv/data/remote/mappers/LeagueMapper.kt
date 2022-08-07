package br.com.jxr.cstv.data.remote.mappers

import br.com.jxr.cstv.data.remote.dto.LeagueDto
import br.com.jxr.cstv.domain.model.League
import javax.inject.Inject

class LeagueMapper @Inject constructor() {
    fun map(leagueDto: LeagueDto) = League(
        leagueDto.name,
        leagueDto.imageUrl.orEmpty()
    )
}
