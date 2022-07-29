package com.jxareas.motionx.domain.model

import com.jxareas.motionx.data.api.dto.model.ApiConfig

class Artwork(
    val id: Int,
    val title: String,
    val imageId: String,
    private val config: ApiConfig
) {

    val imageUrl : String
        get() = "${config.iiifUrl}/$imageId/$DEFAULT_IMAGE_SIZE"

    companion object {
        const val DEFAULT_IMAGE_SIZE : String = "full/843,/0/default.jpg"
    }

}