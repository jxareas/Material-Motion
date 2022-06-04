package com.jxareas.motionx.di

import com.jxareas.motionx.data.mappers.ArtworkMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {

    @Singleton
    @Provides
    fun provideArtworkMapper(): ArtworkMapper =
        ArtworkMapper()

}