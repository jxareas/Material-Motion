package com.jxareas.motionx.di

import com.jxareas.motionx.data.api.dto.model.ApiArtwork
import com.jxareas.motionx.data.api.dto.model.ApiTour
import com.jxareas.motionx.data.mappers.ArtworkMapper
import com.jxareas.motionx.data.mappers.DomainMapper
import com.jxareas.motionx.data.mappers.ToursMapper
import com.jxareas.motionx.domain.model.Artwork
import com.jxareas.motionx.domain.model.Tour
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface MapperConfig {

    @Binds
    @Singleton
    fun bindArtworkMapper(mapper: ArtworkMapper): DomainMapper<ApiArtwork, Artwork>

    @Binds
    @Singleton
    fun bindTourMapper(mapper: ToursMapper): DomainMapper<ApiTour, Tour>


}