package com.ahclipse.data.repository

import com.ahclipse.data.model.LoginRecord
import io.reactivex.Observable

interface LoginRemoteClient {

    fun login(email: String, password: String): Observable<LoginRecord>
}