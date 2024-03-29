package com.jxareas.motionx.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.jxareas.motionx.data.api.constants.ApiEndpoints
import com.jxareas.motionx.data.api.service.ArtworkService
import com.jxareas.motionx.data.api.service.ExhibitionService
import com.jxareas.motionx.data.api.service.TourService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            this.level = HttpLoggingInterceptor.Level.BODY
        }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideJsonConfiguration() = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @Provides
    @Singleton
    fun provideConverter(json: Json): Converter.Factory =
        json.asConverterFactory("application/json".toMediaType())

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient, converter: Converter.Factory): Retrofit =
        Retrofit.Builder()
            .baseUrl(ApiEndpoints.BASE_END_POINT)
            .client(client)
            .addConverterFactory(converter)
            .build()

    @Provides
    @Singleton
    fun provideArtworksService(retrofit: Retrofit): ArtworkService =
        retrofit.create()

    @Provides
    @Singleton
    fun provideTourService(retrofit: Retrofit): TourService =
        retrofit.create()

    @Provides
    @Singleton
    fun provideExhibitionService(retrofit : Retrofit) : ExhibitionService =
        retrofit.create()

}