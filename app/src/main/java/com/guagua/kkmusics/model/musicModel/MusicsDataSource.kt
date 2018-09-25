package com.guagua.kkmusics.model.musicModel

import com.guagua.kkmusics.BaseCallback
import com.guagua.kkmusics.model.domainObject.*

interface MusicsDataSource {

    interface GetTokenCallback : BaseCallback<Token>

    interface GetGenreStationsCallback : BaseCallback<GenreStations>

    interface GetNewHitsPlaylistsCallback : BaseCallback<NewHitsPlaylists>

    interface GetMoodStationsCallback : BaseCallback<MoodStations>

    interface GetNewHitsPlaylistCallback : BaseCallback<NewHitsPlaylist>

    interface GetChartsCallback : BaseCallback<Charts>

    fun getNewHitsPlaylists(callback: GetNewHitsPlaylistsCallback)

    fun getToken(id: String, secret: String, callback: GetTokenCallback)

    fun getGenreStations(callback: GetGenreStationsCallback)

    fun getMoodStations(callback: GetMoodStationsCallback)

    fun getNewHitsPlaylist(playlistId: String, callback: GetNewHitsPlaylistCallback)

    fun getCharts(callback: GetChartsCallback)

}