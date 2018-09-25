package com.guagua.kkmusics.musics

import android.util.Log
import com.guagua.kkmusics.model.domainObject.GenreStations
import com.guagua.kkmusics.model.domainObject.MoodStations
import com.guagua.kkmusics.model.domainObject.NewHitsPlaylists
import com.guagua.kkmusics.model.domainObject.Token
import com.guagua.kkmusics.model.musicModel.MusicsDataSource
import com.guagua.kkmusics.model.musicModel.MusicsRepository
import javax.inject.Inject

class MusicsPresenter @Inject constructor(var musicsRepository: MusicsRepository) : MusicsContract.Presenter{

    val LOG_TAG = "MusicsPresenter"
    private lateinit var view: MusicsContract.View

    override fun getToken(id: String, secret: String) {
        musicsRepository.getToken(id, secret, object : MusicsDataSource.GetTokenCallback{
            override fun onDataReturn(data: Token) {
                Log.d(LOG_TAG, data.accessToken)
                getNewHitsPlaylists()
                getGenreStations()
                getMoodStations()
            }

            override fun onDataNotAvailable() {
                Log.d(LOG_TAG, "Failure")
            }
        })
    }

    override fun getNewHitsPlaylists() {
        musicsRepository.getNewHitsPlaylists(object : MusicsDataSource.GetNewHitsPlaylistsCallback{
            override fun onDataReturn(data: NewHitsPlaylists) {
                view.setNewHitsPlaylists(data)
            }

            override fun onDataNotAvailable() {

            }
        })
    }

    override fun getGenreStations() {
        musicsRepository.getGenreStations(object : MusicsDataSource.GetGenreStationsCallback{
            override fun onDataReturn(data: GenreStations) {
                view.setGenreStations(data)
            }

            override fun onDataNotAvailable() {

            }
        })
    }

    override fun getMoodStations() {
        musicsRepository.getMoodStations(object : MusicsDataSource.GetMoodStationsCallback{
            override fun onDataReturn(data: MoodStations) {
                view.setMoodStations(data)
            }

            override fun onDataNotAvailable() {

            }
        })
    }

    override fun setView(view: MusicsContract.View) {
        this.view = view
    }

}