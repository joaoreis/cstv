package br.com.jxr.cstv.di

import br.com.jxr.cstv.data.remote.repository.MatchRepositoryImpl
import br.com.jxr.cstv.data.remote.repository.TeamRepositoryImpl
import br.com.jxr.cstv.domain.repository.MatchRepository
import br.com.jxr.cstv.domain.repository.TeamRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMatchesRepository(
        matchRepositoryImpl: MatchRepositoryImpl
    ): MatchRepository

    @Binds
    @Singleton
    abstract fun bindTeamsRepository(
        teamRepositoryImpl: TeamRepositoryImpl
    ): TeamRepository
}
