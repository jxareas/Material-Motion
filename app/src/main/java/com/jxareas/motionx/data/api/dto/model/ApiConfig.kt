package com.jxareas.motionx.data.api.dto.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiConfig(
    @SerialName("iiif_url")
    val iiifUrl: String,
    @SerialName("website_url")
    val websiteUrl: String,
)