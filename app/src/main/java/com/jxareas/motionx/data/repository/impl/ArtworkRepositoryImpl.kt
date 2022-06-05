package com.jxareas.motionx.data.repository.impl

import com.jxareas.motionx.data.api.service.ArtworkService
import com.jxareas.motionx.data.domain.model.Artwork
import com.jxareas.motionx.data.mappers.ArtworkMapper
import com.jxareas.motionx.data.repository.ArtworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArtworkRepositoryImpl @Inject constructor(
    private val service: ArtworkService,
    private val mapper: ArtworkMapper,
) : ArtworkRepository {
    override suspend fun getAllArtworks(): Flow<List<Artwork>> =
        flow {
            val response = service.fetchArtworks().data
            val artworks = mapper.mapAllToDomain(response)
            emit(artworks)
        }

    override suspend fun getArtworkById(id : Int): Flow<Artwork> =
        flow {
        val response = service.fetchArtworkById(id).data
        val artwork = mapper.mapToDomain(response)
        emit(artwork)
    }


}