package com.yagizgokce.travelguideapp.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.repository.TravelListRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class TopPickUseCase @Inject constructor(
    private val travelListRepository: TravelListRepository
) {
    private var job : Job? = null
    private var _topPick = MutableLiveData<List<AllTravelListModel>>()
    val topPick: LiveData<List<AllTravelListModel>> = _topPick

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Error: ${throwable.localizedMessage}")
    }

    fun getTopPick(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = travelListRepository.getTravelData("toppick")

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    response.body()?.let {
                        _topPick.value = it
                    }
                }
            }
        }
    }
}