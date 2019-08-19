package com.ahclipse.remote.service

import com.ahclipse.data.model.LoginRecord
import com.ahclipse.data.repository.LoginRemoteClient
import com.ahclipse.remote.service.restaurants.LoginService
import io.reactivex.Observable
import javax.inject.Inject

class LoginRemoteImpl @Inject constructor(
    private val service: LoginService
) : LoginRemoteClient {

    override fun login(email: String, password: String): Observable<LoginRecord> {
        return service.login(email, password)
            .map { loginRecord: com.ahclipse.remote.model.LoginRecord -> LoginRecord(loginRecord.token) }

    }
}