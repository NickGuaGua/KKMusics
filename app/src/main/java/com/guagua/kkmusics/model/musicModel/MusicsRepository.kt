package com.guagua.kkmusics.model.musicModel

import com.guagua.kkmusics.model.domainObject.GenreStations
import com.guagua.kkmusics.model.domainObject.MoodStations
import com.guagua.kkmusics.model.domainObject.NewHitsPlaylists
import com.guagua.kkmusics.model.domainObject.Token
import javax.inject.Inject
import javax.inject.Named

class MusicsRepository: MusicsDataSource{

    var musicsRemoteDataSouce: MusicsDataSource

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

}