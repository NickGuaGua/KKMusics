package com.guagua.kkmusics.newHitsPlaylist

import com.guagua.kkmusics.model.domainObject.NewHitsPlaylist
import com.guagua.kkmusics.model.musicModel.MusicsDataSource
import com.guagua.kkmusics.model.musicModel.MusicsRepository
import javax.inject.Inject

class NewHitsPlaylistPresenter @Inject constructor(private var musicsRepository: MusicsRepository) : NewHitsPlaylistContract.Presenter{

    private lateinit var view: NewHitsPlaylistContract.View

    override fun setView(view: NewHitsPlaylistContract.View) {
        this.view = view
    }

    override fun getNewHitsPlaylist(playlistId: String) {
        musicsRepository.getNewHitsPlaylist(playlistId, object : MusicsDataSource.GetNewHitsPlaylistCallback{
            override fun onDataReturn(data: NewHitsPlaylist) {
                view.setNewHitsPlaylist(data)
            }

            override fun onDataNotAvailable() {

            }
        })
    }

    override fun playTrack(trackId: String) {
        val url = "https://widget.kkbox.com/v1/?id=$trackId&type=song&terr=TW&autoplay=true&loop=false"
        view.loadPlayerWidget(url)
    }

    override fun getPlaylistDataFromIntent() {
        view.getPlaylistDataFromIntent()
    }

    override fun initTitleBar() {
        view.initTitleBar()
    }

    override fun initNewHitsPlaylist() {
        view.initNewHitsPlaylist()
    }
}