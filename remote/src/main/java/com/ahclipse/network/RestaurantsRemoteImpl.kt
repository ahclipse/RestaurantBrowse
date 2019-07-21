package com.ahclipse.network

import com.ahclipse.data.model.RestaurantEntity
import com.ahclipse.data.repository.RestaurantsRemoteClient
import com.ahclipse.network.mapper.RestaurantRecordMapper
import com.ahclipse.network.service.RestaurantService
import io.reactivex.Observable
import javax.inject.Inject

class RestaurantsRemoteImpl @Inject constructor(
    private val service: RestaurantService,
    private val mapper: RestaurantRecordMapper
) : RestaurantsRemoteClient {

    override fun getRestaurants(lat: Double, long: Double): Observable<List<RestaurantEntity>> {
        return service.getRestaurants(lat, long, 0, 50).map { it ->
            it.map { mapper.mapFromRecord(it) }
        }
    }
}