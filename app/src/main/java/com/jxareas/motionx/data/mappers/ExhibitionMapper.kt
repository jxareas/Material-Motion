package com.jxareas.motionx.data.mappers

import com.jxareas.motionx.data.api.dto.model.ApiExhibition
import com.jxareas.motionx.domain.model.Exhibition
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExhibitionMapper @Inject constructor() : DomainMapper<ApiExhibition, Exhibition> {
    override fun mapToDomain(entity: ApiExhibition): Exhibition =
        Exhibition(
            entity.id,
            entity.title,
            entity.description.orEmpty(),
            entity.shortDescription.orEmpty(),
            entity.imageUrl.orEmpty(),
            entity.webUrl.orEmpty(),
        )

    override fun mapFromDomain(domain: Exhibition): ApiExhibition =
        ApiExhibition(
            domain.id,
            domain.title,
            domain.description,
            domain.shortDescription,
            domain.imageUrl,
            domain.webUrl,
        )
}