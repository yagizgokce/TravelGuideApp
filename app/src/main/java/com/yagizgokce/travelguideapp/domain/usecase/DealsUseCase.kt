package com.yagizgokce.travelguideapp.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.repository.TravelListRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class DealsUseCase @Inject constructor(
    private val travelListRepository: TravelListRepository
) {
    private var job : Job? = null

    private var _hotels = MutableLiveData<List<AllTravelListModel>>()
    val hotels: LiveData<List<AllTravelListModel>> = _hotels

    private var _flights = MutableLiveData<List<AllTravelListModel>>()
    val flights: LiveData<List<AllTravelListModel>> = _flights

    private var _transportation = MutableLiveData<List<AllTravelListModel>>()
    val transportation: LiveData<List<AllTravelListModel>> = _transportation

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Error: ${throwable.localizedMessage}")
    }

    fun getHotels(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = travelListRepository.getTravelData("hotel")

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    response.body()?.let {
                        _hotels.value = it
                    }
                }
            }
        }
    }

    fun getFlights(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = travelListRepository.getTravelData("flight")

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    response.body()?.let {
                        _flights.value = it
                    }
                }
            }
        }
    }

    fun getTransportation(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = travelListRepository.getTravelData("transportation")

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    response.body()?.let {
                        _transportation.value = it
                    }
                }
            }
        }
    }

}