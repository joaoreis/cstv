package br.com.jxr.cstv.data.remote.mappers

import br.com.jxr.cstv.data.remote.dto.MatchDto
import br.com.jxr.cstv.data.remote.dto.OpponentDto
import br.com.jxr.cstv.domain.model.Match
import br.com.jxr.cstv.domain.model.MatchStatus
import br.com.jxr.cstv.domain.model.Team
import br.com.jxr.cstv.domain.utils.DateFormatter
import javax.inject.Inject

class MatchMapper @Inject constructor(
    private val leagueMapper: LeagueMapper,
    private val serieMapper: SerieMapper,
    private val matchStatusMapper: MatchStatusMapper,
    private val opponentMapper: OpponentMapper
) {
    fun map(matchDto: MatchDto): Match =
        with(matchDto) {
            val status = matchStatusMapper.map(status)
            Match(
                id = id,
                name = name,
                teams = mapTeams(opponents),
                league = leagueMapper.map(league),
                serie = serieMapper.map(serie),
                status = status,
                beginAt = getFormattedDate(status, beginAt)
            )
        }

    private fun getFormattedDate(status: MatchStatus, dateStr: String): String =
        when (status) {
            MatchStatus.RUNNING -> "AGORA"
            else -> DateFormatter.format(dateStr)
        }

    private fun mapTeams(opponents: List<OpponentDto>): List<Team> {
        val placeHolderTeam = Team(
            id = -1,
            name = "TBD",
            imageUrl = ""
        )
        return when (opponents.size) {
            0 -> listOf(placeHolderTeam, placeHolderTeam)
            1 -> listOf(placeHolderTeam) + opponents.map { opponentMapper.map(it) }
            else -> opponents.map { opponentMapper.map(it) }
        }
    }
}
