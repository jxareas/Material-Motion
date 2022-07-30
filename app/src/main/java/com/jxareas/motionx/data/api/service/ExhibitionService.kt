package com.jxareas.motionx.data.api.service

import com.jxareas.motionx.data.api.constants.ApiConstants
import com.jxareas.motionx.data.api.constants.ApiEndpoints
import com.jxareas.motionx.data.api.constants.ApiParameters
import com.jxareas.motionx.data.api.dto.responses.OneExhibitionResponse
import com.jxareas.motionx.data.api.dto.responses.PaginatedExhibitionsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ExhibitionService {

    @GET(ApiEndpoints.EXHIBITIONS)
    suspend fun fetchLatestExhibitions(
        @Query(ApiParameters.LIMIT) size: Int = ApiConstants.DEFAULT_LIMIT,
    ): PaginatedExhibitionsResponse

    @GET("${ApiEndpoints.EXHIBITIONS}/${ApiParameters.ID}")
    suspend fun fetchExhibitionById(
        @Query(ApiParameters.ID) exhibitionId: Int,
    ): OneExhibitionResponse

}