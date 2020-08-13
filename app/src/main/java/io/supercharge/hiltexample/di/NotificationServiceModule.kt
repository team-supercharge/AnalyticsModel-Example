package io.supercharge.hiltexample.di

import android.app.NotificationManager
import android.content.Context
import androidx.core.content.getSystemService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class NotificationServiceModule {

    @Provides
    @Singleton
    fun provideNotificationManager(@ApplicationContext context: Context) =
        context.getSystemService<NotificationManager>()!!
}
