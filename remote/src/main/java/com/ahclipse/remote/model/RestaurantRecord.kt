package com.ahclipse.remote.model

import com.google.gson.annotations.SerializedName

class RestaurantRecord(
    @SerializedName("id") val id: Long, @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("cover_img_url") val coverImg: String, @SerializedName("status") val status: String,
    @SerializedName("delivery_fee") val deliveryFee: Double
)