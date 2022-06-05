package com.jxareas.motionx.data.api.dto.responses

import com.jxareas.motionx.data.api.dto.model.ApiArtwork
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetOneArtworkResponse(
    @SerialName("data")
    val data : ApiArtwork
)