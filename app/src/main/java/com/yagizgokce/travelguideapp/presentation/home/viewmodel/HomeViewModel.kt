package com.yagizgokce.travelguideapp.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.usecase.DealsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.merge
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dealsUseCase: DealsUseCase
) : ViewModel()  {
    fun getHotels() : LiveData<List<AllTravelListModel>> {

        dealsUseCase.apply {
            getHotels()
            return hotels
        }
    }

    fun getFlights() : LiveData<List<AllTravelListModel>> {

        dealsUseCase.apply {
            getFlights()
            return flights
        }
    }

    fun getTransportation() : LiveData<List<AllTravelListModel>> {

        dealsUseCase.apply {
            getTransportation()
            return transportation
        }
    }

    fun getAll() : LiveData<List<AllTravelListModel>> {

        dealsUseCase.apply {
            getAll()
            return all
        }
    }

}