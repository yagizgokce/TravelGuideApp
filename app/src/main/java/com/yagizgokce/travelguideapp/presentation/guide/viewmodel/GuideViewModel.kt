package com.yagizgokce.travelguideapp.presentation.guide.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.usecase.MightNeedUseCase
import com.yagizgokce.travelguideapp.domain.usecase.TopPickUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GuideViewModel @Inject constructor(
    private val mightNeedUseCase: MightNeedUseCase,
    private val topPickUseCase: TopPickUseCase
): ViewModel() {

    fun getMightNeed() : LiveData<List<AllTravelListModel>>{

        mightNeedUseCase.apply {
            getMightNeed()
            return mightNeed
        }
    }

    fun getTopPick() : LiveData<List<AllTravelListModel>>{

        topPickUseCase.apply {
            getTopPick()
            return topPick
        }
    }
}