package com.guagua.kkmusics.model.musicModel

import com.guagua.kkmusics.model.domainObject.GenreStations
import com.guagua.kkmusics.model.domainObject.MoodStations
import com.guagua.kkmusics.model.domainObject.NewHitsPlaylists
import retrofit2.Call
import retrofit2.http.*

interface MusicApiService{

    @Headers("accept: application/json")
    @GET("/v1.1/new-hits-playlists?territory=JP&offset=0&limit=10")
    fun getNewHitsPlaylists(@Header("authorization") accessToken: String): Call<NewHitsPlaylists>

    @Headers("accept: application/json")
    @GET("/v1.1/genre-stations?territory=JP&offset=0&limit=500")
    fun getGenreStations(@Header("authorization") accessToken: String): Call<GenreStations>

    @Headers("accept: application/json")
    @GET("/v1.1/mood-stations?territory=TW&offset=0&limit=50")
    fun getMoodStations(@Header("authorization") accessToken: String): Call<MoodStations>

}