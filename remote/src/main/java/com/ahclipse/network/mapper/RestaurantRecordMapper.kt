package com.ahclipse.network.mapper

import com.ahclipse.data.model.RestaurantEntity
import com.ahclipse.network.model.RestaurantRecord

class RestaurantRecordMapper : RecordMapper<RestaurantRecord, RestaurantEntity> {

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