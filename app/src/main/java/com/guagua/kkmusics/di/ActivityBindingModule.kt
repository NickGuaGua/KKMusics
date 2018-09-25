package com.guagua.kkmusics.di

import com.guagua.kkmusics.MainActivity
import com.guagua.kkmusics.musics.MusicsModule
import com.guagua.kkmusics.newHitsPlaylist.NewHitsPlaylistActivity
import com.guagua.kkmusics.newHitsPlaylist.NewHitsPlaylistModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule{

    @ActivityScoped
    @ContributesAndroidInjector(modules = [(MusicsModule::class)])
    abstract fun mainActivity(): MainActivity

    @ActivityScoped
    @ContributesAndroidInjector(modules = [(NewHitsPlaylistModule::class)])
    abstract fun newHitsPlaylistActivity(): NewHitsPlaylistActivity

}