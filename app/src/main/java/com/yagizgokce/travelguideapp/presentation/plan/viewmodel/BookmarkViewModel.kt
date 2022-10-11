package com.yagizgokce.travelguideapp.presentation.plan.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.yagizgokce.travelguideapp.domain.model.AllTravelListModel
import com.yagizgokce.travelguideapp.domain.usecase.BookmarkUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookmarkViewModel @Inject constructor(
    private val bookmarkUseCase: BookmarkUseCase
) : ViewModel(){

    fun getBookmarkData() : LiveData<List<AllTravelListModel>> {
        bookmarkUseCase.apply {
            getBookmarkData()
            return bookmark
        }
    }
}