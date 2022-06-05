package com.jxareas.motionx.data.mappers

import com.jxareas.motionx.data.api.dto.model.ApiArtwork
import com.jxareas.motionx.data.api.dto.responses.GetPaginatedArtworksResponse
import com.jxareas.motionx.data.domain.model.Artwork

class ArtworkMapper : DomainMapper<ApiArtwork, Artwork> {

    override fun mapToDomain(entity: ApiArtwork): Artwork =
        Artwork(entity.id, entity.title, entity.imageId, GetPaginatedArtworksResponse.configuration)

    override fun mapFromDomain(domain: Artwork): ApiArtwork =
        ApiArtwork(domain.id, domain.title, domain.imageId)


}