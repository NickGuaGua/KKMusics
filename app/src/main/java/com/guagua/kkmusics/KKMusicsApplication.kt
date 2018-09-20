package com.guagua.kkmusics

import com.guagua.kkmusics.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class KKMusicsApplication: DaggerApplication(){

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

}