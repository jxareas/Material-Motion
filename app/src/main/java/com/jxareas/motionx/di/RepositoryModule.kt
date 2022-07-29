package com.jxareas.motionx.di

import com.jxareas.motionx.domain.repository.ArtworkRepository
import com.jxareas.motionx.data.repository.ArtworkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindArtworkRepository(repository: ArtworkRepositoryImpl): ArtworkRepository
}