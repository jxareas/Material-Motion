package com.jxareas.motionx.ui.exhibitions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jxareas.motionx.domain.model.Exhibition
import com.jxareas.motionx.domain.usecase.GetLatestExhibitionsUseCase
import com.jxareas.motionx.ui.common.state.LoadingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ExhibitionsViewModel @Inject constructor(
    private val latestExhibitionsUseCase: GetLatestExhibitionsUseCase,
) : ViewModel() {


    private val _exhibitions = MutableLiveData<List<Exhibition>>()
    val exhibitions: LiveData<List<Exhibition>>
        get() = _exhibitions

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
                latestExhibitionsUseCase.invoke()
                    .collectLatest { latestArtworks ->
                        _exhibitions.value = latestArtworks
                        _loadingState.value = LoadingState.DONE
                    }
            } catch (exception: IOException) {
                _loadingState.value = LoadingState.ERROR
                exception.printStackTrace()
            }
        }
    }


}