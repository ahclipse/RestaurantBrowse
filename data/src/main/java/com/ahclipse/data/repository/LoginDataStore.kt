package com.ahclipse.data.repository

import com.ahclipse.data.model.LoginRecord
import io.reactivex.Observable

interface LoginDataStore {

    fun login(email: String, password: String): Observable<LoginRecord>
}