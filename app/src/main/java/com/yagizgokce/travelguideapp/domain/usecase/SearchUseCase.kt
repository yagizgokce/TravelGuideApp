package com.yagizgokce.travelguideapp.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.repository.TravelListRepository
import kotlinx.coroutines.*

import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val travelListRepository: TravelListRepository)
{
    private var job : Job? = null
    private var _topDestinations = MutableLiveData<List<AllTravelListModel>>()
    val topDestinations: LiveData<List<AllTravelListModel>> = _topDestinations

    private var _nearBy = MutableLiveData<List<AllTravelListModel>>()
    val nearBy: LiveData<List<AllTravelListModel>> = _nearBy

    private var _filteredData = MutableLiveData<List<AllTravelListModel>>()
    val filteredData: LiveData<List<AllTravelListModel>> = _filteredData

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Error: ${throwable.localizedMessage}")
    }

    fun getTopDestination() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = travelListRepository.getTravelData("topdestination")

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    response.body()?.let {
                       _topDestinations.value = it
                    }
                }
            }
        }
    }

    fun getNearby(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = travelListRepository.getTravelData("nearby")

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    response.body()?.let {
                        _nearBy.value = it
                    }
                }
            }
        }
    }

    fun getSearch(term : String){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = travelListRepository.getTravelData("nearby||topdestination||toppick||nearby")

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    _filteredData.value =  response.body()?.filter {
                         it.city.lowercase() == term.lowercase() ||
                         it.country.lowercase() == term.lowercase()
                    }
                }
            }
        }
    }
}