package br.com.jxr.cstv.data.remote.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class MatchDto(
    val id: Int,
    val name: String,
    val opponents: List<OpponentDto>,
    val league: LeagueDto,
    val serie: SerieDto,
    val status: MatchStatusDto,
    @Json(name = "begin_at")
    val beginAt: String?
) : Parcelable
