package com.guagua.kkmusics

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.guagua.kkmusics.musics.MusicsFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject lateinit var musicsFragment: MusicsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragment =  supportFragmentManager.findFragmentById(R.id.container)
        if (fragment == null)
            fragment = musicsFragment

        supportFragmentManager.beginTransaction().add(R.id.container, fragment).commit()
    }
}
