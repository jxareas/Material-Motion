package com.jxareas.motionx.data.api.dto.responses

import com.jxareas.motionx.data.api.dto.model.ApiExhibition
import com.jxareas.motionx.data.api.dto.model.ApiPagination
import kotlinx.serialization.Serializable

@Serializable
data class PaginatedExhibitionsResponse(
    val pagination: ApiPagination,
    val data: List<ApiExhibition>,
)