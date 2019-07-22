package com.ahclipse.remote.mapper

import com.ahclipse.data.model.RestaurantEntity
import com.ahclipse.remote.model.RestaurantRecord
import javax.inject.Inject

open class RestaurantRecordMapper @Inject constructor() :
    RecordMapper<RestaurantRecord, RestaurantEntity> {

    override fun mapFromRecord(record: RestaurantRecord): RestaurantEntity {
        return RestaurantEntity(
            record.id,
            record.name,
            record.description,
            record.coverImg,
            record.status,
            record.deliveryFee
        )
    }
}