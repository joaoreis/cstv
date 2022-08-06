package br.com.jxr.cstv.data.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Match(
    val id: Int,
    val name: String,
    @Json(name = "begin_at")
    val beginAt: String?
) : Parcelable
