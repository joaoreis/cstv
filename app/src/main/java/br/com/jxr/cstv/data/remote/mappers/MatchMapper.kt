package br.com.jxr.cstv.data.remote.mappers

import br.com.jxr.cstv.data.remote.dto.MatchDto
import br.com.jxr.cstv.domain.model.Match
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
            Match(
                id = id,
                name = name,
                teams = opponents.map { opponentMapper.map(it) },
                league = leagueMapper.map(league),
                serie = serieMapper.map(serie),
                status = matchStatusMapper.map(status),
                beginAt = DateFormatter.format(beginAt)
            )
        }
}
