package com.ahclipse.network.service

import com.ahclipse.network.model.RestaurantResponseRecord
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantService {

    @GET("v2/restaurant")
    fun getRestaurants(
        @Query("lat") latitude: Double, @Query("lng") longitude: Double,
        @Query("offset") offset: Int, @Query("limit") limit: Int
    ): Observable<RestaurantResponseRecord>
}