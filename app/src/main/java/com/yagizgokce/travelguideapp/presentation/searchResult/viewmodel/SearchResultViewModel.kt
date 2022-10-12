package com.yagizgokce.travelguideapp.presentation.searchResult.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.usecase.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
): ViewModel() {

    fun getSearch(term : String): LiveData<List<AllTravelListModel>> {
        searchUseCase.apply {
            getSearch(term)
            return filteredData
        }
    }

}