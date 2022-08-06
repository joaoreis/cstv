package br.com.jxr.cstv.data

import br.com.jxr.cstv.data.model.Match
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://api.pandascore.co/csgo/"
const val NETWORK_PAGE_SIZE = 20

interface PandaScoreApi {

    @GET("/matches")
    suspend fun getMatches(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int = NETWORK_PAGE_SIZE,
        @Query("sort") sort: String,
        @Query("range[begin_at]") beginAt: String
    ): List<Match>
}
