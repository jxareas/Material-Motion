package com.jxareas.motionx.data.api.dto.responses

import com.jxareas.motionx.data.api.dto.model.ApiConfig
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetOneArtworkResponse
    (
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("image_id")
    val imageId: String
)

