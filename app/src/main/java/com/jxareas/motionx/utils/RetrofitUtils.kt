package com.jxareas.motionx.utils

import retrofit2.Retrofit
import retrofit2.create
import kotlin.reflect.KClass

infix fun <T : Any> Retrofit.create(service: KClass<T>): T =
    this.create(service.java)
