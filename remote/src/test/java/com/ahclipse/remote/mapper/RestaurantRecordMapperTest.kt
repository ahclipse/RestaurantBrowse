package com.ahclipse.remote.mapper

import com.ahclipse.remote.factory.RestaurantFactory
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertEquals

@RunWith(JUnit4::class)
class RestaurantRecordMapperTest {

    private val mapper = RestaurantRecordMapper()

    @Test
    fun mapFromRecordMapsData() {
        val record = RestaurantFactory.makeRestaurantRecord()
        val entity = mapper.mapFromRecord(record)

        assertEquals(record.id, entity.id)
        assertEquals(record.name, entity.name)
        assertEquals(record.description, entity.description)
        assertEquals(record.coverImg, entity.coverImg)
        assertEquals(record.status, entity.status)
        assertEquals(record.deliveryFee, entity.deliveryFee)
    }
}