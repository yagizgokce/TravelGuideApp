package com.yagizgokce.travelguideapp.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.repository.TravelListRepository
import kotlinx.coroutines.*

import javax.inject.Inject

class TopDestinationUseCase @Inject constructor(
    private val travelListRepository: TravelListRepository)
{
    private var job : Job? = null
    private var _topDestinations = MutableLiveData<List<AllTravelListModel>>()
    val topDestinations: LiveData<List<AllTravelListModel>> = _topDestinations

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
}