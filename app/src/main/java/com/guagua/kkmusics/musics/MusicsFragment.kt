package com.guagua.kkmusics.musics

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.guagua.kkmusics.R
import com.guagua.kkmusics.di.ActivityScoped
import com.guagua.kkmusics.model.domainObject.GenreStations
import com.guagua.kkmusics.model.domainObject.MoodStations
import com.guagua.kkmusics.model.domainObject.NewHitsPlaylists
import com.guagua.kkmusics.musics.Adapter.GenreStationsAdapter
import com.guagua.kkmusics.musics.Adapter.MoodStationsAdapter
import com.guagua.kkmusics.musics.Adapter.NewHitsPlaylistsAdapter
import com.guagua.kkmusics.newHitsPlaylist.NewHitsPlaylistActivity
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_musics.*
import javax.inject.Inject

@ActivityScoped
class MusicsFragment @Inject constructor(): DaggerFragment(), MusicsContract.View {

    @Inject
    lateinit var presenter: MusicsContract.Presenter

    private lateinit var newHitsPlaylistsAdapter: NewHitsPlaylistsAdapter
    private lateinit var genreStationsAdapter: GenreStationsAdapter
    private lateinit var moodStationsAdapter: MoodStationsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.setView(this)
        newHitsPlaylistsAdapter = NewHitsPlaylistsAdapter()
        genreStationsAdapter = GenreStationsAdapter(resources.getIntArray(R.array.random_color_set))
        moodStationsAdapter = MoodStationsAdapter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_musics, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.getToken(getString(R.string.kkapi_id), getString(R.string.kkapi_secret))
        initNewHitsPlaylists()
        initGenreStations()
        initMoodStations()
    }

    fun initNewHitsPlaylists(){
        val layoutManager = LinearLayoutManager(this.context)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        new_hits_playlists_list.apply {
            setHasFixedSize(true)
            this.layoutManager = layoutManager
            this.adapter = newHitsPlaylistsAdapter
        }

        newHitsPlaylistsAdapter.setOnItemClickListener(object : NewHitsPlaylistsAdapter.onItemClickListener{
            override fun onItemClick(data: NewHitsPlaylists.Data) {
                val intent = Intent(activity, NewHitsPlaylistActivity::class.java)
                val bundle = Bundle()
                bundle.putSerializable("playlist", data)
                bundle.putString("playlist_id", data.id)
                intent.putExtras(bundle)
                startActivity(intent)
                activity!!.overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        })
    }

    fun initGenreStations(){
        val layoutManager = GridLayoutManager(this.context, 2)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        genre_stations_list.apply {
            setHasFixedSize(true)
            this.layoutManager = layoutManager
            this.adapter = genreStationsAdapter
        }
    }

    fun initMoodStations(){
        val layoutManager = GridLayoutManager(this.context, 2)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL

        mood_stations_list.apply {
            setHasFixedSize(true)
            this.layoutManager = layoutManager
            this.adapter = moodStationsAdapter
        }
    }

    override fun setNewHitsPlaylists(playlists: NewHitsPlaylists) {
        newHitsPlaylistsAdapter.setData(playlists)
        new_hits_playlists_progressBar.visibility = View.GONE
    }

    override fun setGenreStations(genreStations: GenreStations) {
        genreStationsAdapter.setData(genreStations)
        genre_stations_progressBar.visibility = View.GONE
    }

    override fun setMoodStations(moodStations: MoodStations) {
        moodStationsAdapter.setData(moodStations)
        mood_stations_progressBar.visibility = View.GONE
    }


}