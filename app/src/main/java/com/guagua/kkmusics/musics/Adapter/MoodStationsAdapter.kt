package com.guagua.kkmusics.musics.Adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.guagua.kkmusics.R
import com.guagua.kkmusics.model.domainObject.MoodStations
import kotlinx.android.synthetic.main.item_mood_stations.view.*

class MoodStationsAdapter(playlist: MoodStations = MoodStations()) : RecyclerView.Adapter<MoodStationsAdapter.ViewHolder>() {

    private var dataset = playlist
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        context = parent.context
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_mood_stations, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        Glide.with(context).load(dataset.datas[i].images[0].url).into(holder.img)
    }

    override fun getItemCount(): Int {
        return dataset.datas.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val img = view.item_mood_stations_img
    }

    fun setData(data: MoodStations){
        dataset = data
        notifyDataSetChanged()
    }
}

