package com.jxareas.motionx.data.repository

import com.jxareas.motionx.data.api.dto.model.ApiArtwork
import com.jxareas.motionx.data.api.service.ArtworkService
import com.jxareas.motionx.domain.model.Artwork
import com.jxareas.motionx.data.mappers.ArtworkMapper
import com.jxareas.motionx.data.mappers.DomainMapper
import com.jxareas.motionx.domain.repository.ArtworkRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


class ArtworkRepositoryImpl @Inject constructor(
    private val service: ArtworkService,
    private val mapper: DomainMapper<ApiArtwork, Artwork>,
) : ArtworkRepository {
    override suspend fun getLatestArtworks(): Flow<List<Artwork>> =
        flow {
            val response = service.fetchLatestArtworks().data
            val artworks = mapper.mapAllToDomain(response)
            emit(artworks)
        }

    override suspend fun getArtworkById(id: Int): Flow<Artwork> =
        flow {
            val response = service.fetchArtworkById(id).data
            val artwork = mapper.mapToDomain(response)
            emit(artwork)
        }


}