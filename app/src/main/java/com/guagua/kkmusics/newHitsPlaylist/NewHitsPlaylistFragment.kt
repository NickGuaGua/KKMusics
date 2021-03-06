package com.guagua.kkmusics.newHitsPlaylist

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.bumptech.glide.Glide
import com.guagua.kkmusics.R
import com.guagua.kkmusics.model.domainObject.NewHitsPlaylist
import com.guagua.kkmusics.model.domainObject.NewHitsPlaylists
import com.guagua.kkmusics.util.WebPlayer
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_new_hits_playlist.*
import javax.inject.Inject


class NewHitsPlaylistFragment @Inject constructor(): DaggerFragment(), NewHitsPlaylistContract.View{

    @Inject lateinit var presenter: NewHitsPlaylistPresenter

    private lateinit var newHitsPlaylistAdapter: NewHitsPlaylistAdapter

    private lateinit var playlist: NewHitsPlaylists.Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.setView(this)
        newHitsPlaylistAdapter = NewHitsPlaylistAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_hits_playlist, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getPlaylistDataFromIntent()
        presenter.initTitleBar()
        presenter.initNewHitsPlaylist()
        presenter.getNewHitsPlaylist(playlist.id)
        presenter.initBanner()
    }

    override fun getPlaylistDataFromIntent(){
        playlist = activity?.intent?.extras!!.getSerializable("playlist") as NewHitsPlaylists.Data
    }

    override fun initTitleBar(){
        (activity!! as AppCompatActivity).setSupportActionBar(toolbar)
        (activity!! as AppCompatActivity).supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        (activity!! as AppCompatActivity).supportActionBar!!.title = playlist.title
    }

    override fun initBanner(){
        Glide.with(activity!!).load(playlist.owner.images[0].url).into(avatar)
        description.text = playlist.description
        Glide.with(activity!!).load(playlist.images[1].url).into(banner_pic)
        owner_name.text = playlist.owner.name
    }

    override fun initNewHitsPlaylist(){
        val layoutManager = LinearLayoutManager(this.context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        new_hits_playlist_list.apply {
            setHasFixedSize(true)
            this.layoutManager = layoutManager
            this.adapter = newHitsPlaylistAdapter

        }

        newHitsPlaylistAdapter.setOnItemClickListener(object : NewHitsPlaylistAdapter.onItemClickListener{
            override fun onItemClick(data: NewHitsPlaylist.Data) {
                presenter.playTrack(data.id)
            }
        })
    }

    override fun setNewHitsPlaylist(playlists: NewHitsPlaylist) {
        newHitsPlaylistAdapter.setData(playlists)
        new_hits_playlist_progressBar.visibility = View.GONE
    }

    override fun loadPlayerWidget(url: String) {
        WebPlayer(this.context!!, coordinatorLayout).autoPlay(url)
    }

    override fun isActive(): Boolean {
        return isAdded
    }
}