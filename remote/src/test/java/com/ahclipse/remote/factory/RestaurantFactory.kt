package com.ahclipse.remote.factory

import com.ahclipse.data.model.RestaurantEntity
import com.ahclipse.remote.model.RestaurantRecord

object RestaurantFactory {

    fun makeRestaurantRecord(): RestaurantRecord {
        return RestaurantRecord(
            DataFactory.randomLong(), DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
            DataFactory.randomUuid(), DataFactory.randomDouble()
        )
    }

    fun makeRestaurantEntity(): RestaurantEntity {
        return RestaurantEntity(
            DataFactory.randomLong(), DataFactory.randomUuid(), DataFactory.randomUuid(), DataFactory.randomUuid(),
            DataFactory.randomUuid(), DataFactory.randomDouble()
        )
    }

    fun makeRestaurantRecordList(): List<RestaurantRecord> {
        val records = mutableListOf<RestaurantRecord>()
        for (x in 0..10) {
            records.add(makeRestaurantRecord())
        }
        return records
    }
}