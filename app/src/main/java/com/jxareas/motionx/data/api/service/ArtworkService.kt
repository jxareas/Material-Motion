package com.jxareas.motionx.data.api.service

import com.jxareas.motionx.data.api.dto.responses.GetOneArtworkResponse
import com.jxareas.motionx.data.api.dto.responses.GetPaginatedArtworksResponse
import com.jxareas.motionx.data.api.utils.ApiConstants
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArtworkService {

    @GET(ApiConstants.ARTWORKS)
    suspend fun fetchLatestArtworks(@Query("limit") size : Int = 40) : GetPaginatedArtworksResponse

    @GET("${ApiConstants.ARTWORKS}/{id}")
    suspend fun fetchArtworkById(@Path("id") artworkId : Int) : GetOneArtworkResponse

}