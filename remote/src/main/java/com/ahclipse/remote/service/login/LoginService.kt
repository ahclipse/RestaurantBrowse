package com.ahclipse.remote.service.restaurants

import com.ahclipse.remote.model.LoginRecord
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {

    @POST("v2/auth/token/")
    fun login(
        @Body email: String, password: String
    ): Observable<LoginRecord>
}