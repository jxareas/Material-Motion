package com.jxareas.motionx.di

import com.jxareas.motionx.data.api.dto.model.ApiArtwork
import com.jxareas.motionx.data.mappers.ArtworkMapper
import com.jxareas.motionx.data.mappers.DomainMapper
import com.jxareas.motionx.domain.repository.ArtworkRepository
import com.jxareas.motionx.data.repository.ArtworkRepositoryImpl
import com.jxareas.motionx.domain.model.Artwork
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

    @Binds
    @Singleton
    fun bindArtworkMapper(mapper: ArtworkMapper): DomainMapper<ApiArtwork, Artwork>
}