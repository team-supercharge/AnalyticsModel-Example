package io.supercharge.hiltexample

import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.supercharge.hiltexample.di.ApplicationComponent
import io.supercharge.hiltexample.di.DaggerApplicationComponent
import javax.inject.Inject

class HiltApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .application(this)
            .context(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }

    override fun androidInjector() = dispatchingAndroidInjector
}
