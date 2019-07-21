package com.ahclipse.data.store

import com.ahclipse.data.model.RestaurantEntity
import com.ahclipse.data.repository.RestaurantsDataStore
import com.ahclipse.data.repository.RestaurantsRemoteClient
import io.reactivex.Observable
import javax.inject.Inject

class RestaurantsRemoteDataStore @Inject constructor(
    private val restaurantsRemoteClient: RestaurantsRemoteClient
) : RestaurantsDataStore {

    override fun getRestaurants(): Observable<List<RestaurantEntity>> {
        return restaurantsRemoteClient.getRestaurants()
    }
}