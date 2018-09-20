package com.guagua.kkmusics.model.musicModel

import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class MusicsRepositoryModule{

    @Provides
    fun provideMusicsRepository(musicsRemoteDataSource: MusicsDataSource) = MusicsRepository(musicsRemoteDataSource)

    @Provides
    fun providesMusicsRemoteDataSource(authApiService: AuthApiService, musicApiService: MusicApiService): MusicsDataSource = MusicsRemoteDataSource(authApiService, musicApiService)

    @Provides
    fun provideAuthApiService() = APIBuilder(AuthApiService::class.java, "https://account.kkbox.com").build()

    @Provides
    fun provideMusicApiService() = APIBuilder(MusicApiService::class.java, "https://api.kkbox.com").build()


}