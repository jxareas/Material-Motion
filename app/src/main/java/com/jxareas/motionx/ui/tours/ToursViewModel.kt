package com.jxareas.motionx.ui.tours

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jxareas.motionx.domain.model.Tour
import com.jxareas.motionx.domain.usecase.GetLatestToursUseCase
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

    init {
        getLatestTours()
    }

    private fun getLatestTours() {
        viewModelScope.launch {
           try {
                latestToursUseCase.invoke()
                    .collectLatest { latestTours ->
                        _tours.postValue(latestTours)
                    }
            } catch(exception: IOException) {

            }
        }
    }

}