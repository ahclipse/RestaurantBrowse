package com.ahclipse.data.repository

import com.ahclipse.data.model.RestaurantEntity
import io.reactivex.Observable

interface RestaurantsRemoteClient {

    fun getRestaurants(): Observable<List<RestaurantEntity>>
}