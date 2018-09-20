package com.guagua.kkmusics.model.musicModel

import com.guagua.kkmusics.BaseCallback
import com.guagua.kkmusics.model.domainObject.GenreStations
import com.guagua.kkmusics.model.domainObject.MoodStations
import com.guagua.kkmusics.model.domainObject.NewHitsPlaylists
import com.guagua.kkmusics.model.domainObject.Token

interface MusicsDataSource{

    interface GetTokenCallback: BaseCallback<Token>

    interface GetGenreStationsCallback: BaseCallback<GenreStations>

    interface GetNewHitsPlaylistsCallback: BaseCallback<NewHitsPlaylists>

    interface GetMoodStationsCallback: BaseCallback<MoodStations>

    fun getNewHitsPlaylists(callback: GetNewHitsPlaylistsCallback)

    fun getToken(id: String, secret: String, callback: GetTokenCallback)

    fun getGenreStations(callback: GetGenreStationsCallback)

    fun getMoodStations(callback: GetMoodStationsCallback)

}