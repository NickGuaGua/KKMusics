package com.guagua.kkmusics.model.musicModel

import android.os.TokenWatcher
import android.util.Log
import com.guagua.kkmusics.BaseCallback
import com.guagua.kkmusics.model.domainObject.*
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Named

class MusicsRemoteDataSource: MusicsDataSource {

    val LOG_TAG = "MusicsAPI"
    private var musicApiService: MusicApiService
    private var authApiService: AuthApiService
    private var TOKEN: Token = Token()

    @Inject
    constructor(authApiService: AuthApiService, musicApiService: MusicApiService){
        this.authApiService = authApiService
        this.musicApiService = musicApiService
    }

    private fun generateCredential(id: String, secret: String): String {
        val key = "$id:$secret".toByteArray()
        Log.d(LOG_TAG, "$id:$secret")
        return android.util.Base64.encode(key, android.util.Base64.DEFAULT).toString(Charsets.UTF_8)
    }

    override fun getToken(id: String, secret: String, callback: MusicsDataSource.GetTokenCallback) {

        if (TOKEN.accessToken.isNotEmpty())
            callback.onDataReturn(TOKEN)
        else {
            var credential = "Basic " + generateCredential(id, secret)
            credential = credential.replace("\n", "")
            Log.d(LOG_TAG, credential)

            authApiService.getToken(credential).enqueue(object : retrofit2.Callback<Token> {
                override fun onFailure(call: Call<Token>?, t: Throwable?) {
                    Log.d(LOG_TAG, "Failure: ${t.toString()}")
                    callback.onDataNotAvailable()
                }

                override fun onResponse(call: Call<Token>?, response: Response<Token>?) {
                    if (response?.body() != null) {
                        val token = response.body()!!
                        Log.d(LOG_TAG, token.accessToken)
                        TOKEN = token
                        callback.onDataReturn(token)
                    } else callback.onDataNotAvailable()
                }
            })
        }
    }

    override fun getNewHitsPlaylists(callback: MusicsDataSource.GetNewHitsPlaylistsCallback) {
        musicApiService.getNewHitsPlaylists("${TOKEN.tokenType} ${TOKEN.accessToken}").enqueue(object : retrofit2.Callback<NewHitsPlaylists>{

            override fun onFailure(call: Call<NewHitsPlaylists>?, t: Throwable?) {
                Log.d(LOG_TAG, "getNewHitsPlaylists() Failure: ${t.toString()}")
            }

            override fun onResponse(call: Call<NewHitsPlaylists>?, response: Response<NewHitsPlaylists>?) {
                if (response?.body() != null) {
                    val newHitsPlaylists = response.body()!!
                    callback.onDataReturn(newHitsPlaylists)
                }
                else callback.onDataNotAvailable()
            }
        })
    }

    override fun getGenreStations(callback: MusicsDataSource.GetGenreStationsCallback) {
        musicApiService.getGenreStations("${TOKEN.tokenType} ${TOKEN.accessToken}").enqueue(object : retrofit2.Callback<GenreStations>{
            override fun onFailure(call: Call<GenreStations>?, t: Throwable?) {
                Log.d(LOG_TAG, "getGenreStations() Failure: ${t.toString()}")
            }

            override fun onResponse(call: Call<GenreStations>?, response: Response<GenreStations>?) {
                if (response?.body() != null) {
                    val genreStations = response.body()!!
                    callback.onDataReturn(genreStations)
                }
                else callback.onDataNotAvailable()
            }
        })
    }

    override fun getMoodStations(callback: MusicsDataSource.GetMoodStationsCallback) {
        musicApiService.getMoodStations("${TOKEN.tokenType} ${TOKEN.accessToken}").enqueue(object : retrofit2.Callback<MoodStations>{
            override fun onFailure(call: Call<MoodStations>?, t: Throwable?) {
                Log.d(LOG_TAG, "getMoodStations() Failure: ${t.toString()}")
            }

            override fun onResponse(call: Call<MoodStations>?, response: Response<MoodStations>?) {
                if (response?.body() != null) {
                    val moodStations = response.body()!!
                    callback.onDataReturn(moodStations)
                }
                else callback.onDataNotAvailable()
            }
        })
    }

    override fun getNewHitsPlaylist(playlistId: String, callback: MusicsDataSource.GetNewHitsPlaylistCallback) {
        musicApiService.getNewHitsPlaylist("${TOKEN.tokenType} ${TOKEN.accessToken}", playlistId).enqueue(object : retrofit2.Callback<NewHitsPlaylist>{
            override fun onFailure(call: Call<NewHitsPlaylist>?, t: Throwable?) {
                Log.d(LOG_TAG, "getNewHitsPlaylist() Failure: ${t.toString()}")
            }

            override fun onResponse(call: Call<NewHitsPlaylist>?, response: Response<NewHitsPlaylist>?) {

                if (response?.body() != null) {
                    val newHitsPlaylist = response.body()!!
                    callback.onDataReturn(newHitsPlaylist)
                }
                else callback.onDataNotAvailable()
            }
        })
    }
}