package com.jxareas.motionx.di

import com.jxareas.motionx.data.repository.ArtworkRepositoryImpl
import com.jxareas.motionx.data.repository.ExhibitionRepositoryImpl
import com.jxareas.motionx.data.repository.TourRepositoryImpl
import com.jxareas.motionx.domain.repository.ArtworkRepository
import com.jxareas.motionx.domain.repository.ExhibitionRepository
import com.jxareas.motionx.domain.repository.TourRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
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
    fun bindToursRepository(repository: TourRepositoryImpl): TourRepository

    @Binds
    @Singleton
    fun bindExhibitionRepository(repository: ExhibitionRepositoryImpl): ExhibitionRepository

}