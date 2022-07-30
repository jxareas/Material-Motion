package com.jxareas.motionx.data.api.dto.responses

import com.jxareas.motionx.data.api.dto.model.ApiTour
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OneTourResponse(
    @SerialName("data")
    val data: ApiTour,
)