package br.com.jxr.cstv.data.model.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamDetailsDto(
    val id: Int,
    val players: List<PlayerDto>
) : Parcelable
