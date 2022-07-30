package com.jxareas.motionx.data.api.dto.responses

import com.jxareas.motionx.data.api.dto.model.ApiArtwork
import com.jxareas.motionx.data.api.dto.model.ApiConfig
import com.jxareas.motionx.data.api.dto.model.ApiPagination
import kotlinx.serialization.Serializable

@Serializable
data class PaginatedArtworksResponse(
    val pagination : ApiPagination,
    val data : List<ApiArtwork>,
    val config : ApiConfig
) {
    companion object {
        lateinit var configuration: ApiConfig
    }

    init {
        configuration = this.config
    }


}
