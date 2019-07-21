package com.ahclipse.network.mapper

interface RecordMapper<in R, out E> {

    fun mapFromRecord(record: R): E
}