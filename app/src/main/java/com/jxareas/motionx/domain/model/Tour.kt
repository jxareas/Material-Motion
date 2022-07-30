package com.jxareas.motionx.domain.model

import kotlinx.serialization.SerialName

data class Tour(
    val id: Int,
    val title: String,
    val description: String,
    val intro: String,
    @SerialName("image")
    val image: String,
    val artworkTitles: List<String>,
    val artistTitles: List<String>,
    val lastUpdated: String?,
    val timestamp: String?,
) {
    // For some unknown reason, the API returns the HTTP file instead of the HTTPS
    // There's the option to enable android:usesCleartextTraffic in the Manifest File.
    val imageUrl : String
        get() = image.replace("http", "https")

}