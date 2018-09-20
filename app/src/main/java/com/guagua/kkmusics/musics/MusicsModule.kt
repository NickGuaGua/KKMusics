package com.guagua.kkmusics.musics

import com.guagua.kkmusics.di.ActivityScoped
import com.guagua.kkmusics.di.FragmentScoped
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MusicsModule{

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun musicsFragment(): MusicsFragment

    @ActivityScoped
    @Binds
    abstract fun musicsPresenter(presenter: MusicsPresenter): MusicsContract.Presenter

}