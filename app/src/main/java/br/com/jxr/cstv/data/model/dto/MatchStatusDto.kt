package br.com.jxr.cstv.data.model.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
enum class MatchStatusDto : Parcelable {
    @Json(name = "canceled")
    CANCELLED,

    @Json(name = "finished")
    FINISHED,

    @Json(name = "not_started")
    NOT_STARTED,

    @Json(name = "postponed")
    POSTPONED,

    @Json(name = "running")
    RUNNING,
}
