package com.guagua.kkmusics.model.musicModel

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class MusicsRepositoryModule{

    @Singleton
    @Provides
    fun provideMusicsRepository(musicsRemoteDataSource: MusicsDataSource) = MusicsRepository(musicsRemoteDataSource)

    @Singleton
    @Provides
    fun providesMusicsRemoteDataSource(authApiService: AuthApiService, musicApiService: MusicApiService): MusicsDataSource = MusicsRemoteDataSource(authApiService, musicApiService)

    @Singleton
    @Provides
    fun provideAuthApiService() = APIBuilder(AuthApiService::class.java, "https://account.kkbox.com").build()

    @Singleton
    @Provides
    fun provideMusicApiService() = APIBuilder(MusicApiService::class.java, "https://api.kkbox.com").build()

}