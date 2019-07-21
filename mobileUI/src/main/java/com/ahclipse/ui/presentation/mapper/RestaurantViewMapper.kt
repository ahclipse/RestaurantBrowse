package com.ahclipse.ui.presentation.mapper

import com.ahclipse.data.model.RestaurantEntity
import com.ahclipse.ui.presentation.model.RestaurantView
import javax.inject.Inject

class RestaurantViewMapper @Inject constructor() : Mapper<RestaurantView, RestaurantEntity> {

    override fun mapToView(entity: RestaurantEntity): RestaurantView {
        return RestaurantView(
            entity.id, entity.name, entity.description, entity.coverImg, entity.status, entity.deliveryFee
        )
    }
}