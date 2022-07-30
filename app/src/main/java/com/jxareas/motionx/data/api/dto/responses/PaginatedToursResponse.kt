package com.jxareas.motionx.data.api.dto.responses

import com.jxareas.motionx.data.api.dto.model.ApiConfig
import com.jxareas.motionx.data.api.dto.model.ApiPagination
import com.jxareas.motionx.data.api.dto.model.ApiTour
import kotlinx.serialization.Serializable

@Serializable
data class PaginatedToursResponse(
    val pagination: ApiPagination,
    val data: List<ApiTour>,
    val config: ApiConfig,
)