package io.supercharge.hiltexample.di

import android.app.NotificationManager
import android.content.Context
import androidx.core.content.getSystemService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NotificationServiceModule {

    @Provides
    @Singleton
    fun provideNotificationManager(context: Context) =
        context.getSystemService<NotificationManager>()!!
}
