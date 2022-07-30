package com.jxareas.motionx.data.repository

import com.jxareas.motionx.data.api.dto.model.ApiExhibition
import com.jxareas.motionx.data.api.service.ExhibitionService
import com.jxareas.motionx.data.mappers.DomainMapper
import com.jxareas.motionx.domain.model.Exhibition
import com.jxareas.motionx.domain.repository.ExhibitionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ExhibitionRepositoryImpl @Inject constructor(
    private val service: ExhibitionService,
    private val mapper: DomainMapper<ApiExhibition, Exhibition>,
) : ExhibitionRepository {
    override suspend fun getLatestExhibitions(): Flow<List<Exhibition>> =
        flow {
            val response = service.fetchLatestExhibitions().data
            val exhibitions = mapper.mapAllToDomain(response)
            emit(exhibitions)
        }

    override suspend fun geExhibitionById(id: Int): Flow<Exhibition> =
        flow {
            val response = service.fetchExhibitionById(id).data
            val exhibition = mapper.mapToDomain(response)
            emit(exhibition)
        }


}