package com.jxareas.motionx.domain.repository

import com.jxareas.motionx.domain.model.Artwork
import kotlinx.coroutines.flow.Flow

interface ArtworkRepository {

    suspend fun getLatestArtworks() : Flow<List<Artwork>>

    suspend fun getArtworkById(id : Int) : Flow<Artwork>

}