package com.jxareas.motionx.domain.repository

import com.jxareas.motionx.domain.model.Exhibition
import kotlinx.coroutines.flow.Flow

interface ExhibitionRepository {
    suspend fun getLatestExhibitions(): Flow<List<Exhibition>>

    suspend fun geExhibitionById(id: Int): Flow<Exhibition>

}