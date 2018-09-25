package com.guagua.kkmusics.newHitsPlaylist

import com.guagua.kkmusics.di.ActivityScoped
import com.guagua.kkmusics.di.FragmentScoped
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewHitsPlaylistModule{

    @FragmentScoped
    @ContributesAndroidInjector
    abstract fun newHitsPlaylistFragment(): NewHitsPlaylistFragment

    @ActivityScoped
    @Binds
    abstract fun newHitsPlaylistPresenter(presenter: NewHitsPlaylistPresenter): NewHitsPlaylistContract.Presenter

}