package com.jxareas.motionx.data.api.dto.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiTour(
    val id: Int,
    val title: String,
    val intro: String?,
    val description: String?,
    val image: String?,
    @SerialName("artist_titles")
    val artistTitles: List<String> = emptyList(),
    @SerialName("artwork_titles")
    val artworkTitles: List<String> = emptyList(),
    @SerialName("last_updated")
    val lastUpdated: String?,
    val timestamp: String,
    )