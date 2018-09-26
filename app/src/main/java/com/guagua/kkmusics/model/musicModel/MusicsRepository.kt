package com.guagua.kkmusics.model.musicModel

import com.guagua.kkmusics.model.domainObject.*
import javax.inject.Inject
import javax.inject.Named

open class MusicsRepository: MusicsDataSource{

    private var musicsRemoteDataSouce: MusicsDataSource

    @Inject
    constructor(musicsRemoteDataSouce: MusicsDataSource){
        this.musicsRemoteDataSouce = musicsRemoteDataSouce
    }

    override fun getToken(id: String, secret: String, callback: MusicsDataSource.GetTokenCallback) {
        musicsRemoteDataSouce.getToken(id, secret, object: MusicsDataSource.GetTokenCallback{
            override fun onDataReturn(data: Token) {
                callback.onDataReturn(data)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }

    override fun getNewHitsPlaylists(callback: MusicsDataSource.GetNewHitsPlaylistsCallback) {
        musicsRemoteDataSouce.getNewHitsPlaylists(object : MusicsDataSource.GetNewHitsPlaylistsCallback{
            override fun onDataReturn(data: NewHitsPlaylists) {
                callback.onDataReturn(data)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }

    override fun getGenreStations(callback: MusicsDataSource.GetGenreStationsCallback) {
        musicsRemoteDataSouce.getGenreStations(object : MusicsDataSource.GetGenreStationsCallback{
            override fun onDataReturn(data: GenreStations) {
                callback.onDataReturn(data)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }

    override fun getMoodStations(callback: MusicsDataSource.GetMoodStationsCallback) {
        musicsRemoteDataSouce.getMoodStations(object : MusicsDataSource.GetMoodStationsCallback{
            override fun onDataReturn(data: MoodStations) {
                callback.onDataReturn(data)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }

    override fun getNewHitsPlaylist(playlistId: String, callback: MusicsDataSource.GetNewHitsPlaylistCallback) {
        musicsRemoteDataSouce.getNewHitsPlaylist(playlistId, object : MusicsDataSource.GetNewHitsPlaylistCallback{
            override fun onDataReturn(data: NewHitsPlaylist) {
                callback.onDataReturn(data)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }

    override fun getCharts(callback: MusicsDataSource.GetChartsCallback) {
        musicsRemoteDataSouce.getCharts(object : MusicsDataSource.GetChartsCallback{
            override fun onDataReturn(data: Charts) {
                callback.onDataReturn(data)
            }

            override fun onDataNotAvailable() {
                callback.onDataNotAvailable()
            }
        })
    }
}