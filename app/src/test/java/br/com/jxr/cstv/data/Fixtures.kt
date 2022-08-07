package br.com.jxr.cstv.data

import br.com.jxr.cstv.di.NetworkModule

val api = NetworkModule.providePandaScoreApi(
    NetworkModule.provideRetrofit(
        NetworkModule.provideOkhttpClient(),
        NetworkModule.provideMoshi()
    )
)
