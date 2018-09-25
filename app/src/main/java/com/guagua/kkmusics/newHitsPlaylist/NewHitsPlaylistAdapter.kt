package com.guagua.kkmusics.newHitsPlaylist

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.guagua.kkmusics.BaseCallback
import com.guagua.kkmusics.R
import com.guagua.kkmusics.model.domainObject.NewHitsPlaylist
import com.guagua.kkmusics.model.domainObject.NewHitsPlaylists
import kotlinx.android.synthetic.main.item_new_hits_playlist.view.*
import kotlinx.android.synthetic.main.item_new_hits_playlists.view.*


class NewHitsPlaylistAdapter(playlist: NewHitsPlaylist = NewHitsPlaylist()) : RecyclerView.Adapter<NewHitsPlaylistAdapter.ViewHolder>(), View.OnClickListener {

    interface onItemClickListener{
        fun onItemClick(data: NewHitsPlaylist.Data)
    }

    private lateinit var listener: onItemClickListener
    private var dataset = playlist
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        context = parent.context
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_new_hits_playlist, parent, false)
        view.setOnClickListener(this)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        holder.name.text = dataset.tracks.datas[i].name
        holder.artist.text = dataset.tracks.datas[i].album.artist.name
        holder.itemView.tag = dataset.tracks.datas[i]
    }

    override fun getItemCount(): Int {
        return dataset.tracks.datas.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name = view.name
        val artist = view.artist
        val playButton = view.play

    }

    fun setData(data: NewHitsPlaylist){
        dataset = data
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        this.listener = listener
    }

    override fun onClick(v: View) {
        if (listener != null)
            listener.onItemClick(v.tag as NewHitsPlaylist.Data)
    }

}

