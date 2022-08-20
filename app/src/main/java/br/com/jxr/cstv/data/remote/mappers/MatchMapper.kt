package br.com.jxr.cstv.data.remote.mappers

import br.com.jxr.cstv.data.remote.dto.MatchDto
import br.com.jxr.cstv.domain.model.Match
import br.com.jxr.cstv.domain.model.MatchStatus
import br.com.jxr.cstv.domain.utils.DateFormatter

fun MatchDto.toMatch(): Match {
    val status = statusDto.toMatchStatus()
    return Match(
        id = id,
        name = name,
        teams = opponentsDto.toTeams(),
        league = leagueDto.toLeague(),
        serie = serieDto.toSerie(),
        status = status,
        beginAt = getFormattedDate(status, beginAt)
    )
}

private fun getFormattedDate(status: MatchStatus, dateStr: String): String =
    when (status) {
        MatchStatus.RUNNING -> "AGORA"
        else -> DateFormatter.format(dateStr)
    }
