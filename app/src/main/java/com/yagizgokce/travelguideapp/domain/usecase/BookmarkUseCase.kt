package com.yagizgokce.travelguideapp.domain.usecase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.repository.TravelListRepository
import kotlinx.coroutines.*
import javax.inject.Inject

class BookmarkUseCase @Inject constructor(
    private val travelListRepository: TravelListRepository
) {
    private var job : Job? = null
    private var _bookmark = MutableLiveData<List<AllTravelListModel>>()
    val bookmark: LiveData<List<AllTravelListModel>> = _bookmark

    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        println("Error: ${throwable.localizedMessage}")
    }

    fun getBookmarkData(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = travelListRepository.getBookmarkData(true)

            withContext(Dispatchers.Main){
                if(response.isSuccessful){
                    response.body()?.let {
                        _bookmark.value = it
                    }
                }
            }
        }
    }
}