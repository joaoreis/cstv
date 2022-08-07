package br.com.jxr.cstv.data.remote.api

import br.com.jxr.cstv.data.remote.dto.MatchDto
import br.com.jxr.cstv.data.remote.dto.TeamDetailsDto
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://api.pandascore.co/csgo/"
const val NETWORK_PAGE_SIZE = 20

interface PandaScoreApi {

    @GET("matches")
    suspend fun getMatches(
        @Query("page") page: Int,
        @Query("per_page") pageSize: Int = NETWORK_PAGE_SIZE,
        @Query("sort") sort: String,
        @Query("range[begin_at]") beginAt: String
    ): List<MatchDto>

    @GET("teams")
    suspend fun getTeams(
        @Query("filter[id]") teamIds: String
    ): List<TeamDetailsDto>
}
