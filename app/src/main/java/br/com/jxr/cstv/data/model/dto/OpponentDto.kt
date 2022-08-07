package br.com.jxr.cstv.data.model.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OpponentDto(
    val type: OpponentTypeDto,
    val opponent: TeamDto?
) : Parcelable
