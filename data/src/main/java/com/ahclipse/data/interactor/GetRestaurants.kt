package com.ahclipse.data.interactor

import com.ahclipse.data.executor.PostExecutionThread
import com.ahclipse.data.model.RestaurantEntity
import com.ahclipse.data.repository.RestaurantsRemoteClient
import io.reactivex.Observable
import javax.inject.Inject

class GetRestaurants @Inject constructor(
    private val restaurantsRemoteClient: RestaurantsRemoteClient, postExecutionThread: PostExecutionThread
) : ObservableUseCase<List<RestaurantEntity>, GetRestaurants.Params?>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<List<RestaurantEntity>> {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return restaurantsRemoteClient.getRestaurants(params.lat, params.long)
    }

    data class Params constructor(val lat: Double, val long: Double) {
        companion object {
            fun forProject(lat: Double, long: Double): Params {
                return Params(lat, long)
            }
        }
    }
}