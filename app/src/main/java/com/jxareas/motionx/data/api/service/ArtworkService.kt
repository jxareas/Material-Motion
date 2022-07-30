package com.jxareas.motionx.data.api.service

import com.jxareas.motionx.data.api.dto.responses.GetOneArtworkResponse
import com.jxareas.motionx.data.api.dto.responses.GetPaginatedArtworksResponse
import com.jxareas.motionx.data.api.constants.ApiEndpoints
import com.jxareas.motionx.data.api.constants.ApiParameters
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArtworkService {

    @GET(ApiEndpoints.ARTWORKS)
    suspend fun fetchLatestArtworks(@Query(ApiParameters.LIMIT) size: Int = 40): GetPaginatedArtworksResponse

    @GET("${ApiEndpoints.ARTWORKS}/${ApiParameters.ID}")
    suspend fun fetchArtworkById(@Path(ApiParameters.ID) artworkId: Int): GetOneArtworkResponse

}