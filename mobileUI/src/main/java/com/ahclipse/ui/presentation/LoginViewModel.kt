package com.ahclipse.ui.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahclipse.data.interactor.GetRestaurants
import com.ahclipse.data.model.RestaurantEntity
import com.ahclipse.ui.presentation.mapper.RestaurantViewMapper
import com.ahclipse.ui.presentation.model.RestaurantView
import com.ahclipse.ui.presentation.state.Resource
import com.ahclipse.ui.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    private val getRestaurants: GetRestaurants,
    private val mapper: RestaurantViewMapper
) : ViewModel() {

    val liveData: MutableLiveData<Resource<List<RestaurantView>>> = MutableLiveData()

    private val latitude = 37.422740
    private val longitude = -122.139956

    override fun onCleared() {
        getRestaurants.dispose()
        super.onCleared()
    }

    fun fetchRestaurants() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        getRestaurants.execute(RestaurantsSubscriber(), GetRestaurants.Params(latitude, longitude))
    }

    inner class RestaurantsSubscriber : DisposableObserver<List<RestaurantEntity>>() {
        override fun onNext(t: List<RestaurantEntity>) {
            liveData.postValue(
                Resource(
                    ResourceState.SUCCESS,
                    t.map { mapper.mapToView(it) }, null
                )
            )
        }

        override fun onComplete() {
            // No implementation required
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }

    }
}