package com.ahclipse.data.interactor

import com.ahclipse.data.executor.PostExecutionThread
import com.ahclipse.data.model.RestaurantEntity
import com.ahclipse.data.repository.RestaurantsRemoteClient
import io.reactivex.Observable
import javax.inject.Inject

class GetRestaurants @Inject constructor(
    private val restaurantsRemoteClient: RestaurantsRemoteClient, postExecutionThread: PostExecutionThread
) : ObservableUseCase<List<RestaurantEntity>, Nothing?>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Nothing?): Observable<List<RestaurantEntity>> {
        return restaurantsRemoteClient.getRestaurants()
    }
}