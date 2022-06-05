package com.jxareas.motionx.data.api.dto.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiArtwork
    (
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("image_id")
    val imageId: String
)

