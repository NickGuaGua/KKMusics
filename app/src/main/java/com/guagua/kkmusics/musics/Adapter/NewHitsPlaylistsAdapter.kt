package com.guagua.kkmusics.musics.Adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.guagua.kkmusics.R
import com.guagua.kkmusics.model.domainObject.NewHitsPlaylists
import kotlinx.android.synthetic.main.item_new_hits_playlists.view.*


class NewHitsPlaylistsAdapter(val playlist: NewHitsPlaylists = NewHitsPlaylists()) : RecyclerView.Adapter<NewHitsPlaylistsAdapter.ViewHolder>() {

    private var dataset = playlist
    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        context = parent.context
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_new_hits_playlists, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        holder.title.text = dataset.datas[i].title
        holder.owner.text = dataset.datas[i].owner.name
        Glide.with(context).load(dataset.datas[i].images[0].url).into(holder.image)
    }

    override fun getItemCount(): Int {
        return dataset.datas.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val image = view.item_new_hit_playlist_image
        val title = view.item_new_hit_playlist_title
        val owner = view.item_new_hit_playlist_owner_name
    }

    fun setData(data: NewHitsPlaylists){
        dataset = data
        notifyDataSetChanged()
    }

}

