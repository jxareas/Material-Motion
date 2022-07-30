package com.jxareas.motionx.data.api.service

import com.jxareas.motionx.data.api.constants.ApiConstants
import com.jxareas.motionx.data.api.constants.ApiEndpoints
import com.jxareas.motionx.data.api.constants.ApiParameters
import com.jxareas.motionx.data.api.dto.responses.OneArtworkResponse
import com.jxareas.motionx.data.api.dto.responses.PaginatedArtworksResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArtworkService {

    @GET(ApiEndpoints.ARTWORKS)
    suspend fun fetchLatestArtworks(
        @Query(ApiParameters.LIMIT) size: Int = ApiConstants.DEFAULT_LIMIT,
    ): PaginatedArtworksResponse

    @GET("${ApiEndpoints.ARTWORKS}/${ApiParameters.ID}")
    suspend fun fetchArtworkById(
        @Path(ApiParameters.ID) artworkId: Int,
    ): OneArtworkResponse

}