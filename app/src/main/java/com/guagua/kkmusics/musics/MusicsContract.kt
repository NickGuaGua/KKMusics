package com.guagua.kkmusics.musics

import com.guagua.kkmusics.BasePresenter
import com.guagua.kkmusics.model.domainObject.GenreStations
import com.guagua.kkmusics.model.domainObject.MoodStations
import com.guagua.kkmusics.model.domainObject.NewHitsPlaylists

interface MusicsContract{

    interface View {
        fun setNewHitsPlaylist(playlists: NewHitsPlaylists)
        fun setGenreStations(genreStations: GenreStations)
        fun setMoodStations(moodStations: MoodStations)
    }

    interface Presenter: BasePresenter<View> {
        fun getToken(id: String, secret: String)
        fun getNewHitsPlaylists()
        fun getGenreStations()
        fun getMoodStations()
    }
}