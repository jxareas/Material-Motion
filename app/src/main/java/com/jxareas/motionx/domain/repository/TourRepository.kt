package com.jxareas.motionx.domain.repository

import com.jxareas.motionx.domain.model.Tour
import kotlinx.coroutines.flow.Flow

interface TourRepository {
    suspend fun getLatestTours(): Flow<List<Tour>>

    suspend fun getTourById(id: Int): Flow<Tour>
}