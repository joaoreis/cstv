package br.com.jxr.cstv.data

import br.com.jxr.cstv.data.remote.api.PandaScoreApi
import br.com.jxr.cstv.di.NetworkModule
import io.mockk.coEvery
import io.mockk.mockk

val api = NetworkModule.providePandaScoreApi(
    NetworkModule.provideRetrofit(
        NetworkModule.provideOkhttpClient(),
        NetworkModule.provideMoshi()
    )
)

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
