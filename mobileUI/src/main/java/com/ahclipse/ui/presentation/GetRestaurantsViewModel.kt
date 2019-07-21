package com.ahclipse.ui.presentation

import androidx.lifecycle.LiveData
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

class GetRestaurantsViewModel @Inject constructor(
    private val getRestaurants: GetRestaurants, private val mapper: RestaurantViewMapper
) : ViewModel() {

    private val liveData: MutableLiveData<Resource<List<RestaurantView>>> = MutableLiveData()

    override fun onCleared() {
        getRestaurants.dispose()
        super.onCleared()
    }

    fun getRestaurants(): LiveData<Resource<List<RestaurantView>>> {
        return liveData
    }

    fun fetchRestaurants() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        getRestaurants.execute(RestaurantsSubscriber())
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