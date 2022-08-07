package br.com.jxr.cstv.data.remote.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class TeamDto(
    val id: Int,
    val name: String,
    @Json(name = "image_url")
    val imageUrl: String?
) : Parcelable
