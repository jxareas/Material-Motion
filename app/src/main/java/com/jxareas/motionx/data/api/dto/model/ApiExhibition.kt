package com.jxareas.motionx.data.api.dto.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiExhibition(
    val id: Int,
    val title: String,
    val description: String?,
    @SerialName("short_description")
    val shortDescription: String?,
    @SerialName("image_url")
    val imageUrl : String?,
    @SerialName("web_url")
    val webUrl : String?,
)