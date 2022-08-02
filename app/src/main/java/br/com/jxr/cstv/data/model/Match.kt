package br.com.jxr.cstv.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Match(
    val id: Int
) : Parcelable
