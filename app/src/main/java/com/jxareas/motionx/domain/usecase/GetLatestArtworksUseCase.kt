package com.jxareas.motionx.domain.usecase

import com.jxareas.motionx.domain.model.Artwork
import com.jxareas.motionx.domain.repository.ArtworkRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@ViewModelScoped
class GetLatestArtworksUseCase @Inject constructor(
    private val artworkRepository: ArtworkRepository,
) {

    suspend operator fun invoke() : Flow<List<Artwork>> =
        artworkRepository.getLatestArtworks()


}