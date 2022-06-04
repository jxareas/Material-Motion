package com.jxareas.motionx.di

import com.jxareas.motionx.data.repository.ArtworkRepository
import com.jxareas.motionx.data.repository.impl.ArtworkRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindArtworkRepository(repository : ArtworkRepositoryImpl) : ArtworkRepository
}