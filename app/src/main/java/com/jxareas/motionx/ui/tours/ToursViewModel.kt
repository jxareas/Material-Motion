package com.jxareas.motionx.ui.tours

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jxareas.motionx.domain.model.Tour
import com.jxareas.motionx.domain.usecase.GetLatestToursUseCase
import com.jxareas.motionx.ui.common.state.LoadingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class ToursViewModel @Inject constructor(
    private val latestToursUseCase: GetLatestToursUseCase,
) : ViewModel() {

    private val _tours = MutableLiveData<List<Tour>>()
    val tours: LiveData<List<Tour>>
        get() = _tours

    private val _loadingState = MutableLiveData<LoadingState>()
    val loadingState: LiveData<LoadingState>
        get() = _loadingState

    init {
        getLatestTours()
    }

    private fun getLatestTours() {
        viewModelScope.launch {
            try {
                _loadingState.value = LoadingState.LOADING
                latestToursUseCase.invoke()
                    .collectLatest { latestTours ->
                        _tours.value = latestTours
                        _loadingState.value = LoadingState.DONE
                    }
            } catch (exception: IOException) {
                _loadingState.value = LoadingState.ERROR
                exception.printStackTrace()
            }
        }
    }

}