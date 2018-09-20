package com.guagua.kkmusics.di

import android.app.Application
import com.guagua.kkmusics.KKMusicsApplication
import com.guagua.kkmusics.model.musicModel.MusicsRepositoryModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(MusicsRepositoryModule::class), (ActivityBindingModule::class), (AndroidSupportInjectionModule::class)])
interface AppComponent: AndroidInjector<KKMusicsApplication>{

    @Component.Builder
    interface Builder {
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): AppComponent.Builder
    }

}