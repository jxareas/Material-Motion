package com.jxareas.motionx.ui.artworks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jxareas.motionx.domain.model.Artwork
import com.jxareas.motionx.domain.usecase.GetLatestArtworksUseCase
import com.jxareas.motionx.ui.common.state.LoadingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtworksViewModel @Inject constructor(
    private val latestArtworksUseCase: GetLatestArtworksUseCase,
) : ViewModel() {

    private val _artworks = MutableLiveData<List<Artwork>>()
    val artworks: LiveData<List<Artwork>>
        get() = _artworks

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    init {
        getLatestArtworks()
    }

    private fun getLatestArtworks() {
        viewModelScope.launch {
            try {
                _loadingState.value = LoadingState.LOADING
                latestArtworksUseCase.invoke()
                    .collectLatest { latestArtworks ->
                        _artworks.value = latestArtworks
                        _loadingState.value = LoadingState.DONE
                    }
            } catch (exception: Exception) {
                _loadingState.value = LoadingState.ERROR
                if (exception is CancellationException)
                    throw exception
            }
        }
    }

}