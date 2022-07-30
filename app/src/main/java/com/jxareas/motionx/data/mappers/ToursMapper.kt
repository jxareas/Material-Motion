package com.jxareas.motionx.data.mappers

import com.jxareas.motionx.data.api.dto.model.ApiTour
import com.jxareas.motionx.domain.model.Tour
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ToursMapper @Inject constructor() : DomainMapper<ApiTour, Tour> {
    override fun mapToDomain(entity: ApiTour): Tour =
        Tour(
            id = entity.id,
            title = entity.title,
            description = entity.description.orEmpty(),
            intro = entity.intro.orEmpty(),
            image = entity.image.orEmpty(),
            artworkTitles = entity.artworkTitles,
            artistTitles = entity.artistTitles,
            lastUpdated = entity.lastUpdated.orEmpty(),
            timestamp = entity.lastUpdated.orEmpty(),
        )

    override fun mapFromDomain(domain: Tour): ApiTour =
        ApiTour(
            id = domain.id,
            title = domain.title,
            intro = domain.intro,
            description = domain.intro,
            image = domain.image,
            artistTitles = domain.artistTitles,
            artworkTitles = domain.artworkTitles,
            lastUpdated = domain.lastUpdated,
            timestamp = domain.timestamp.orEmpty(),
        )
}