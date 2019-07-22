package com.ahclipse.remote

import com.ahclipse.data.model.RestaurantEntity
import com.ahclipse.remote.factory.RestaurantFactory
import com.ahclipse.remote.mapper.RestaurantRecordMapper
import com.ahclipse.remote.model.RestaurantRecord
import com.ahclipse.remote.service.RestaurantService
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class RestaurantsRemoteImplTest {

    private val mapper = mock<RestaurantRecordMapper>()
    private val service = mock<RestaurantService>()
    private val remote = RestaurantsRemoteImpl(service, mapper)
    private val testLat = 45.5
    private val testLong = -34.5

    @Test
    fun getRestaurantsCompletes() {
        stubRestaurantService(
            Observable.just(
                RestaurantFactory.makeRestaurantRecordList()
            )
        )
        stubModelMapperMapFromRecord(
            any(),
            RestaurantFactory.makeRestaurantEntity()
        )

        val testObserver = remote.getRestaurants(testLat, testLong).test()
        testObserver.assertComplete()
    }

    @Test
    fun getRestaurantsCallsServer() {
        stubRestaurantService(
            Observable.just(
                RestaurantFactory.makeRestaurantRecordList()
            )
        )
        stubModelMapperMapFromRecord(
            any(),
            RestaurantFactory.makeRestaurantEntity()
        )

        remote.getRestaurants(testLat, testLong).test()
        verify(service).getRestaurants(testLat, testLong, 0, 50)
    }

    @Test
    fun getRestaurantsReturnsData() {
        val response = RestaurantFactory.makeRestaurantRecordList()
        stubRestaurantService(Observable.just(response))
        val entities = mutableListOf<RestaurantEntity>()
        response.forEach {
            val entity = RestaurantFactory.makeRestaurantEntity()
            entities.add(entity)
            stubModelMapperMapFromRecord(it, entity)
        }
        val testObserver = remote.getRestaurants(testLat, testLong).test()
        testObserver.assertValue(entities)
    }

    private fun stubRestaurantService(
        observable: Observable<List<RestaurantRecord>>
    ) {
        whenever(service.getRestaurants(any(), any(), any(), any()))
            .thenReturn(observable)
    }

    private fun stubModelMapperMapFromRecord(
        record: RestaurantRecord,
        entity: RestaurantEntity
    ) {
        whenever(mapper.mapFromRecord(record))
            .thenReturn(entity)
    }
}