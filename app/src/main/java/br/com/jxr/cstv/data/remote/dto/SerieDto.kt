package br.com.jxr.cstv.data.remote.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class SerieDto(
    @Json(name = "full_name")
    val fullName: String
) : Parcelable
