package br.com.jxr.cstv.data.remote.dto

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlayerDto(
    val id: Int,
    val name: String,
    @Json(name = "first_name")
    val firstName: String?,
    @Json(name = "last_name")
    val lastName: String?,
    @Json(name = "image_url")
    val imageUrl: String?
) : Parcelable
