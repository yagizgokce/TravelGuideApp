package com.yagizgokce.travelguideapp.presentation.guide.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.usecase.GuideUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GuideViewModel @Inject constructor(
    private val guideUseCase: GuideUseCase
): ViewModel() {

    fun getMightNeed() : LiveData<List<AllTravelListModel>>{

        guideUseCase.apply {
            getMightNeed()
            return mightNeed
        }
    }

    fun getTopPick() : LiveData<List<AllTravelListModel>>{

        guideUseCase.apply {
            getTopPick()
            return topPick
        }
    }
}