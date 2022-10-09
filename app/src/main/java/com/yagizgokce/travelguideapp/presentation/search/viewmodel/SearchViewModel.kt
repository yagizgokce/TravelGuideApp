package com.yagizgokce.travelguideapp.presentation.search.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import com.yagizgokce.travelguideapp.data.local.TravelListDatabase
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.usecase.NearbyUseCase
import com.yagizgokce.travelguideapp.domain.usecase.TopDestinationUseCase
import com.yagizgokce.travelguideapp.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    application: Application,
    private val topDestinationUseCase: TopDestinationUseCase,
    private val nearbyUseCase: NearbyUseCase
): BaseViewModel(application) {

    fun getTopDestination() : LiveData<List<AllTravelListModel>>{
        topDestinationUseCase.apply {
            getTopDestination()
            return topDestinations
        }
    }
    fun getNearby() : LiveData<List<AllTravelListModel>>{
        nearbyUseCase.apply {
            getNearby()
            return nearBy
        }
    }
    fun sqlLiteSave(travelList: List<AllTravelListModel>){
        launch {
            val dao = TravelListDatabase(getApplication()).travelListDAO()
            dao.insertAll(*travelList.toTypedArray())
        }
    }
}