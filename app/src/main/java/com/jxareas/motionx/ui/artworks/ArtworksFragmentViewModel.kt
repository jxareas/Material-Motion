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
class ArtworksFragmentViewModel @Inject constructor(
    private val repository: ArtworkRepository,
    private val dispatchers: DispatcherProvider,
) :
    ViewModel() {

    private var _artworks = MutableLiveData<List<Artwork>>()
    internal val artworks: LiveData<List<Artwork>> = _artworks

    init {
        fetchArtworks()
    }

    private fun fetchArtworks() {
        viewModelScope.launch(dispatchers.default) {
            repository.getAllArtworks().collectLatest { artworksResponse ->
                _artworks.postValue(artworksResponse)
            }
        }
    }


}