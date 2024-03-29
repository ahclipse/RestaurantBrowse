package com.ahclipse.data.repository

import com.ahclipse.data.model.RestaurantEntity
import io.reactivex.Observable

interface RestaurantsDataStore {

    fun getRestaurants(lat: Double, long: Double): Observable<List<RestaurantEntity>>
}