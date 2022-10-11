package com.yagizgokce.travelguideapp.presentation.plan.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yagizgokce.travelguideapp.data.local.TripPlanDatabase
import com.yagizgokce.travelguideapp.domain.model.TripPlanModel
import com.yagizgokce.travelguideapp.domain.repository.TravelListRepository
import com.yagizgokce.travelguideapp.domain.repository.TripPlanRepository
import com.yagizgokce.travelguideapp.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TripPlanViewModel  @Inject  constructor(
    application : Application
) : BaseViewModel(application) {

    val tripPlanLiveData = MutableLiveData <List<TripPlanModel>>()

    fun saveSql(tripPlan : TripPlanModel){

        launch {

            val dao = TripPlanDatabase(getApplication()).tripPlanDAO()
            dao.insertAll(tripPlan)
        }

    }

    fun getSqlData(): LiveData<List<TripPlanModel>> {
        launch {
            val dao = TripPlanDatabase(getApplication()).tripPlanDAO()
            dao.getAllPlanData().collect(){ datas ->
                tripPlanLiveData.postValue(datas)
            }
        }
        return tripPlanLiveData
    }
}