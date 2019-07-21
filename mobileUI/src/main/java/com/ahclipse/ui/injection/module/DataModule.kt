package com.ahclipse.ui.injection.module

import com.ahclipse.data.repository.RestaurantsDataStore
import com.ahclipse.data.store.RestaurantsRemoteDataStore
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindRemoteDataStore(dataStore: RestaurantsRemoteDataStore): RestaurantsDataStore
}