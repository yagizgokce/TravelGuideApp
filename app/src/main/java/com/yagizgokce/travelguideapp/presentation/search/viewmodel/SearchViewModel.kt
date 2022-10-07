package com.yagizgokce.travelguideapp.presentation.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.usecase.TopDestinationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val topDestinationUseCase: TopDestinationUseCase
): ViewModel() {
    fun getTopDestination() : LiveData<List<AllTravelListModel>>{
        topDestinationUseCase.apply {
            getTopDestination()
            return topDestinations
        }
    }

}