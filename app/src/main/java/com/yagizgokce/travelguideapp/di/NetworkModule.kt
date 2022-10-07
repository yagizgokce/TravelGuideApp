package com.yagizgokce.travelguideapp.di

import com.google.gson.Gson
import com.squareup.moshi.Moshi
import com.yagizgokce.travelguideapp.data.remote.ApiService
import com.yagizgokce.travelguideapp.data.remote.repository.TravelListRepositoryImp
import com.yagizgokce.travelguideapp.domain.repository.TravelListRepository
import com.yagizgokce.travelguideapp.utils.Constants.Companion.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {


    @Provides
    @Singleton
    fun providesRetrofit(
        moshiConverterFactory: MoshiConverterFactory,
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(): MoshiConverterFactory {
        return MoshiConverterFactory.create(Moshi.Builder().build())
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideTopDestinationRepository(apiService: ApiService): TravelListRepository {
        return TravelListRepositoryImp(apiService)
    }

}