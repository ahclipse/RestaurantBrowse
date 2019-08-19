package com.ahclipse.remote.model

import com.google.gson.annotations.SerializedName

data class LoginRecord(
    @SerializedName("token") val token: String
)