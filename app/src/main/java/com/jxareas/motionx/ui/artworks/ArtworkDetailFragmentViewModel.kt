package com.jxareas.motionx.ui.artworks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jxareas.motionx.data.domain.model.Artwork
import com.jxareas.motionx.data.repository.ArtworkRepository
import com.jxareas.motionx.utils.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtworkDetailFragmentViewModel @Inject constructor(
    private val repository: ArtworkRepository,
    private val dispatchers: DispatcherProvider,
) : ViewModel() {

    private var _artwork = MutableLiveData<Artwork>()
    internal val artwork: LiveData<Artwork> = _artwork
    
    fun fetchArtworkById(id : Int) {
        viewModelScope.launch(dispatchers.default) {
            repository.getArtworkById(id).collectLatest { currentArtwork ->
                _artwork.postValue(currentArtwork)
            }
        }
    }
    
}