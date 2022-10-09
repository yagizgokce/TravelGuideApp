package com.yagizgokce.travelguideapp.presentation.Detail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel

class DetailViewModel : ViewModel() {

    val travelDetailLiveData = MutableLiveData<AllTravelListModel>()

}