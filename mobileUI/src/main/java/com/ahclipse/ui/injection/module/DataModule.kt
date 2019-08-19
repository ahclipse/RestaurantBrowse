package com.ahclipse.ui.injection.module

import com.ahclipse.data.repository.LoginDataStore
import com.ahclipse.data.repository.RestaurantsDataStore
import com.ahclipse.data.store.LoginRemoteDataStore
import com.ahclipse.data.store.RestaurantsRemoteDataStore
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun bindRemoteDataStore(dataStore: RestaurantsRemoteDataStore): RestaurantsDataStore

    @Binds
    abstract fun bindLoginRemoteDataStore(dataStore: LoginRemoteDataStore): LoginDataStore
}