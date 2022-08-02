package br.com.jxr.cstv.data

import br.com.jxr.cstv.data.model.Match
import retrofit2.http.GET
import retrofit2.http.Query

const val baseUrl = "https://api.pandascore.co/csgo/"

interface PandaScoreApi {

    @GET("/matches")
    suspend fun getMatches(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int = 20,
        @Query("sort") sort: String,
        @Query("range[begin_at]") beginAt: String
    ): List<Match>
}
