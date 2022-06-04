package com.jxareas.motionx.data.mappers

import com.jxareas.motionx.data.api.dto.responses.GetOneArtworkResponse
import com.jxareas.motionx.data.api.dto.responses.GetPaginatedArtworksResponse
import com.jxareas.motionx.data.domain.model.Artwork

class ArtworkMapper : DomainMapper<GetOneArtworkResponse, Artwork> {

    override fun mapToDomain(entity: GetOneArtworkResponse): Artwork =
        Artwork(entity.id, entity.title, entity.imageId, GetPaginatedArtworksResponse.configuration)

    override fun mapFromDomain(domain: Artwork): GetOneArtworkResponse =
        GetOneArtworkResponse(domain.id, domain.title, domain.imageId)


}