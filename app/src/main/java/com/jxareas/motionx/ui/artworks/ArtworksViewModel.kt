package com.jxareas.motionx.ui.artworks

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jxareas.motionx.domain.model.Artwork
import com.jxareas.motionx.domain.usecase.GetLatestArtworksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtworksViewModel @Inject constructor(
    private val getLatestArtworksUseCase: GetLatestArtworksUseCase,
) : ViewModel() {

    private val _artworks = MutableLiveData<List<Artwork>>()
    val artworks: LiveData<List<Artwork>>
        get() = _artworks

    init {
        getLatestArtworks()
    }

    private fun getLatestArtworks() {
        viewModelScope.launch {
            getLatestArtworksUseCase.invoke()
                .collectLatest { latestArtworks ->
                    _artworks.postValue(latestArtworks)
                }
        }
    }

}