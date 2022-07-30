package com.jxareas.motionx.data.api.service

import com.jxareas.motionx.data.api.constants.ApiConstants
import com.jxareas.motionx.data.api.constants.ApiEndpoints
import com.jxareas.motionx.data.api.constants.ApiParameters
import com.jxareas.motionx.data.api.dto.responses.OneTourResponse
import com.jxareas.motionx.data.api.dto.responses.PaginatedToursResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TourService {

    @GET(ApiEndpoints.TOURS)
    suspend fun fetchLatestTours(
        @Query(ApiParameters.LIMIT) size: Int = ApiConstants.DEFAULT_LIMIT,
    ): PaginatedToursResponse

    @GET("${ApiEndpoints.TOURS}/${ApiParameters.ID}")
    suspend fun fetchTourById(
        @Path(ApiParameters.ID) tourId: Int,
    ): OneTourResponse


}