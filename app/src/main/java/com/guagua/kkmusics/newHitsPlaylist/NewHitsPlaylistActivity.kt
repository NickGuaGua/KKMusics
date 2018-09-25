package com.guagua.kkmusics.newHitsPlaylist

import android.os.Bundle
import com.guagua.kkmusics.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class NewHitsPlaylistActivity: DaggerAppCompatActivity(){

    @Inject lateinit var newHitsPlaylistFragment: NewHitsPlaylistFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_hits_play_activity)

        var fragment =  supportFragmentManager.findFragmentById(R.id.container)
        if (fragment == null) {
            fragment = newHitsPlaylistFragment
            supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
        }
    }
}