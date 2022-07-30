package com.jxareas.motionx.domain.usecase

import com.jxareas.motionx.domain.model.Exhibition
import com.jxareas.motionx.domain.repository.ExhibitionRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class GetLatestExhibitionsUseCase @Inject constructor(
    private val exhibitionRepository: ExhibitionRepository,
) {

    suspend operator fun invoke(): Flow<List<Exhibition>> =
        exhibitionRepository.getLatestExhibitions()

}