package com.jxareas.motionx.domain.usecase

import com.jxareas.motionx.domain.model.Tour
import com.jxareas.motionx.domain.repository.TourRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class GetLatestToursUseCase @Inject constructor(
    private val toursRepository: TourRepository,
) {

    suspend operator fun invoke(): Flow<List<Tour>> =
        toursRepository.getLatestTours()
}