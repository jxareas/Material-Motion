package com.jxareas.motionx.data.repository

import com.jxareas.motionx.data.domain.model.Artwork
import kotlinx.coroutines.flow.Flow

interface ArtworkRepository {

    suspend fun getAllArtworks() : Flow<List<Artwork>>

}