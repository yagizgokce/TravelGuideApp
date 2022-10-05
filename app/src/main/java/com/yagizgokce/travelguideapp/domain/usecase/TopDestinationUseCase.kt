package com.yagizgokce.travelguideapp.domain.usecase

import com.yagizgokce.travelguideapp.domain.model.search.TopDestinationModel
import com.yagizgokce.travelguideapp.domain.repository.TopDestinationRepository
import kotlinx.coroutines.*

import javax.inject.Inject

class TopDestinationUseCase @Inject constructor(
    private val topDestinationRepository: TopDestinationRepository)
{   private var job : Job? = null
    fun getTopDestination(){
        /*job = CoroutineScope(Dispatchers.IO).launch {
            val response = topDestinationRepository.getTopDestination("topdestination")

            withContext(Dispatchers.Main)*/
        }
    }
}