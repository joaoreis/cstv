package br.com.jxr.cstv.data.remote.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
enum class OpponentTypeDto : Parcelable {
    @Json(name = "Team")
    TEAM,

    @Json(name = "Player")
    PLAYER
}
