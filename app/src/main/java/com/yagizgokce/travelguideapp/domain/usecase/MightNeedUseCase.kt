package com.yagizgokce.travelguideapp.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.repository.TravelListRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class MightNeedUseCase @Inject constructor(
    private val travelListRepository: TravelListRepository
) {
    private var job : Job? = null
    private var _mightNeed = MutableLiveData<List<AllTravelListModel>>()
    val mightNeed: LiveData<List<AllTravelListModel>> = _mightNeed

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Error: ${throwable.localizedMessage}")
    }

    fun getMightNeed(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = travelListRepository.getTravelData("nearby")

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    response.body()?.let {
                        _mightNeed.value = it
                    }
                }
            }
        }
    }
}