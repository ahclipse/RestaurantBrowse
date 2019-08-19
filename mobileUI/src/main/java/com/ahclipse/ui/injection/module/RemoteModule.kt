package com.ahclipse.ui.injection.module

import com.ahclipse.data.repository.LoginRemoteClient
import com.ahclipse.data.repository.RestaurantsRemoteClient
import com.ahclipse.remote.RestaurantsRemoteImpl
import com.ahclipse.remote.service.LoginRemoteImpl
import com.ahclipse.remote.service.restaurants.LoginService
import com.ahclipse.remote.service.restaurants.LoginServiceFactory
import com.ahclipse.remote.service.restaurants.RestaurantService
import com.ahclipse.remote.service.restaurants.RestaurantServiceFactory
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

        @Provides
        @JvmStatic
        fun provideLoginService(): LoginService {
            return LoginServiceFactory.makeLoginService(BuildConfig.DEBUG)
        }
    }

    @Binds
    abstract fun bindsRestaurantsRemote(restaurantsRemote: RestaurantsRemoteImpl): RestaurantsRemoteClient

    @Binds
    abstract fun bindsLoginRemote(loginRemote: LoginRemoteImpl): LoginRemoteClient
}