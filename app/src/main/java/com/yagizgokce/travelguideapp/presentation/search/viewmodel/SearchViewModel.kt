package com.yagizgokce.travelguideapp.presentation.search.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
): ViewModel() {

    fun getTopDestination() : LiveData<List<AllTravelListModel>>{
        searchUseCase.apply {
            getTopDestination()
            return topDestinations
        }
    }
    fun getNearby() : LiveData<List<AllTravelListModel>>{
        searchUseCase.apply {
            getNearby()
            return nearBy
        }
    }



}