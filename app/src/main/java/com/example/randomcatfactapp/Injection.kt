package com.example.randomcatfactapp

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Injection {

    @Singleton
    @Provides
    fun provideApiService(): CatInterface =
        Retrofit.Builder()
            .baseUrl("https://meowfacts.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CatInterface::class.java)

    @Singleton
    @Provides
    fun provideRepository(): MainRepository = MainRepository(provideApiService())
}