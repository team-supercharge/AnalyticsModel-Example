package io.supercharge.hiltexample.io.supercharge.hiltexample.di.qualifier

import dagger.MapKey
import io.supercharge.hiltexample.analytics.AnalyticsModel
import kotlin.reflect.KClass

@MapKey
annotation class AnalyticsModelKey(val value: KClass<out AnalyticsModel<*>>)
