package com.yagizgokce.travelguideapp.presentation.Detail.viewmodel

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.repository.TravelListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val travelListRepository: TravelListRepository
)
    : ViewModel() {
    private var job : Job? = null
    fun addBookmark(allTravelListModel: AllTravelListModel){
        job = CoroutineScope(Dispatchers.IO).launch {
            travelListRepository.updateData(allTravelListModel.id.toInt(),allTravelListModel)
        }

    }

}