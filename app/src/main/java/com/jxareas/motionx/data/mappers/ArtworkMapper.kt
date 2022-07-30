package com.jxareas.motionx.data.mappers

import com.jxareas.motionx.data.api.dto.model.ApiArtwork
import com.jxareas.motionx.data.api.dto.responses.PaginatedArtworksResponse
import com.jxareas.motionx.domain.model.Artwork
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArtworkMapper @Inject constructor() : DomainMapper<ApiArtwork, Artwork> {

    override fun mapToDomain(entity: ApiArtwork): Artwork =
        Artwork(entity.id,
            entity.title,
            entity.imageId.orEmpty(),
            PaginatedArtworksResponse.configuration)

    override fun mapFromDomain(domain: Artwork): ApiArtwork =
        ApiArtwork(domain.id, domain.title, domain.imageId)


}