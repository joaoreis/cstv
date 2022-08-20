package br.com.jxr.cstv.data

import br.com.jxr.cstv.data.remote.MatchRemoteDataSource
import br.com.jxr.cstv.data.remote.PandaScoreApi
import br.com.jxr.cstv.data.remote.repository.MatchRepositoryImpl
import br.com.jxr.cstv.di.AppModule
import io.mockk.coEvery
import io.mockk.mockk

val api = AppModule.providePandaScoreApi(
    AppModule.provideRetrofit(
        AppModule.provideOkhttpClient(),
        AppModule.provideMoshi()
    )
)

val dataSource = MatchRemoteDataSource(api)
val repository = MatchRepositoryImpl(dataSource)
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
