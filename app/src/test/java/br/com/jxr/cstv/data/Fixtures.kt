package br.com.jxr.cstv.data

import br.com.jxr.cstv.data.remote.MatchRemoteDataSource
import br.com.jxr.cstv.data.remote.PandaScoreApi
import br.com.jxr.cstv.data.remote.mappers.*
import br.com.jxr.cstv.data.remote.repository.MatchRepositoryImpl
import br.com.jxr.cstv.di.NetworkModule
import io.mockk.coEvery
import io.mockk.mockk

val api = NetworkModule.providePandaScoreApi(
    NetworkModule.provideRetrofit(
        NetworkModule.provideOkhttpClient(),
        NetworkModule.provideMoshi()
    )
)

val dataSource = MatchRemoteDataSource(api)

val matchMapper = MatchMapper(
    LeagueMapper(),
    SerieMapper(),
    MatchStatusMapper(),
    OpponentMapper()
)

val repository = MatchRepositoryImpl(dataSource, matchMapper = matchMapper)

val mockApi = mockk<PandaScoreApi>()
fun mockSuccesResponse() {
    coEvery {
        mockApi.getMatches(
            page = any(),
            pageSize = any(),
            sort = any(),
            beginAt = any()
        )
    } returns emptyList()
}
