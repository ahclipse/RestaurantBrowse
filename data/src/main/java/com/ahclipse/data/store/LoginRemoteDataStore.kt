package com.ahclipse.data.store

import com.ahclipse.data.model.LoginRecord
import com.ahclipse.data.repository.LoginDataStore
import com.ahclipse.data.repository.LoginRemoteClient
import io.reactivex.Observable
import javax.inject.Inject

class LoginRemoteDataStore @Inject constructor(
    private val loginRemoteClient: LoginRemoteClient
) : LoginDataStore {

    override fun login(email: String, password: String): Observable<LoginRecord> {
        return loginRemoteClient.login(email, password)
    }
}