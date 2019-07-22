package com.ahclipse.ui.injection.module

import com.ahclipse.data.repository.RestaurantsRemoteClient
import com.ahclipse.remote.RestaurantsRemoteImpl
import com.ahclipse.remote.service.RestaurantService
import com.ahclipse.remote.service.RestaurantServiceFactory
import com.ahclipse.ui.BuildConfig
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class RemoteModule {

    @Module
    companion object {
        @Provides
        @JvmStatic
        fun provideRestaurantService(): RestaurantService {
            return RestaurantServiceFactory.makeRestaurantService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindsRestaurantsRemote(restaurantsRemote: RestaurantsRemoteImpl): RestaurantsRemoteClient
}