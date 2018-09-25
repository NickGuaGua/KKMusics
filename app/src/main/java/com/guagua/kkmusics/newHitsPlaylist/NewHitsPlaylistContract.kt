package com.guagua.kkmusics.newHitsPlaylist

import com.guagua.kkmusics.BasePresenter
import com.guagua.kkmusics.model.domainObject.NewHitsPlaylist

interface NewHitsPlaylistContract{

    interface View{
        fun getPlaylistDataFromIntent()
        fun initTitleBar()
        fun initNewHitsPlaylist()
        fun setNewHitsPlaylist(playlists: NewHitsPlaylist)
        fun loadPlayerWidget(url: String)
    }

    interface Presenter: BasePresenter<View>{
        fun getNewHitsPlaylist(playlistId: String)
        fun playTrack(trackId: String)
        fun getPlaylistDataFromIntent()
        fun initTitleBar()
        fun initNewHitsPlaylist()
    }
}