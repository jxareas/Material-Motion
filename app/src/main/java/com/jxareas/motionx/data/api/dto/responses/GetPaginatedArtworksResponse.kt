package com.jxareas.motionx.data.api.dto.responses

import com.jxareas.motionx.data.api.dto.model.ApiConfig
import com.jxareas.motionx.data.api.dto.model.ApiPagination
import kotlinx.serialization.Serializable

@Serializable
data class GetPaginatedArtworksResponse(
    val pagination : ApiPagination,
    val data : List<GetOneArtworkResponse>,
    val config : ApiConfig
) {
    companion object {
        lateinit var configuration: ApiConfig
    }

    init {
        configuration = this.config
    }


}