package com.jxareas.motionx.di

import android.os.Build.VERSION_CODES.S
import com.jxareas.motionx.utils.DefaultDispatchers
import com.jxareas.motionx.utils.DispatcherProvider
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
   fun bindDispatchers(): DispatcherProvider =
       DefaultDispatchers
}