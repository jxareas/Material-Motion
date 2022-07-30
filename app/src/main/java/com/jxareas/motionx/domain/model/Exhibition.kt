package com.jxareas.motionx.domain.model

data class Exhibition(
    val id: Int,
    val title: String,
    val description: String,
    val shortDescription: String,
    val imageUrl : String,
    val webUrl : String,
)