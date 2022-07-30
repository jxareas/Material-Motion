package com.jxareas.motionx.data.repository

import com.jxareas.motionx.data.api.dto.model.ApiTour
import com.jxareas.motionx.data.api.service.TourService
import com.jxareas.motionx.data.mappers.DomainMapper
import com.jxareas.motionx.domain.model.Tour
import com.jxareas.motionx.domain.repository.TourRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class TourRepositoryImpl @Inject constructor(
    private val service: TourService,
    private val mapper: DomainMapper<ApiTour, Tour>,
) : TourRepository {
    override suspend fun getLatestTours(): Flow<List<Tour>> =
        flow {
            val response = service.fetchLatestTours().data
            val tours = mapper.mapAllToDomain(response)
            emit(tours)
        }

    override suspend fun getTourById(id: Int): Flow<Tour> =
        flow {
            val response = service.fetchTourById(id).data
            val artwork = mapper.mapToDomain(response)
            emit(artwork)
        }
}