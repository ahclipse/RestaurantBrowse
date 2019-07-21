package com.ahclipse.data.repository

import com.ahclipse.data.model.RestaurantEntity
import io.reactivex.Observable

interface RestaurantsRemoteClient {

    fun getRestaurants(lat: Double, long: Double): Observable<List<RestaurantEntity>>
}