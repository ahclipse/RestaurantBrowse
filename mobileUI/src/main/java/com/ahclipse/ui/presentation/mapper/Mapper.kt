package com.ahclipse.ui.presentation.mapper

interface Mapper<out V, in E> {

    fun mapToView(entity: E): V
}