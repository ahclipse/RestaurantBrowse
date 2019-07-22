package com.ahclipse.remote.mapper

interface RecordMapper<in R, out E> {

    fun mapFromRecord(record: R): E
}