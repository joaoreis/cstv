package br.com.jxr.cstv.data.remote.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class MatchDto(
    val id: Int,
    val name: String,
    val opponentsDto: List<OpponentDto>?,
    val leagueDto: LeagueDto?,
    val serieDto: SerieDto?,
    val statusDto: MatchStatusDto?,
    @Json(name = "begin_at")
    val beginAt: String
) : Parcelable
