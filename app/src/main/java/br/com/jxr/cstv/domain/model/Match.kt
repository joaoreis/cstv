package br.com.jxr.cstv.domain.model

data class Match(
    val id: Int,
    val name: String,
    val teams: List<Team>,
    val league: League,
    val serie: Serie,
    val status: MatchStatus,
    val beginAt: String
)
