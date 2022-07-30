package com.jxareas.motionx.data.api.dto.responses

import com.jxareas.motionx.data.api.dto.model.ApiExhibition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OneExhibitionResponse(
    @SerialName("data")
    val data: ApiExhibition,
)