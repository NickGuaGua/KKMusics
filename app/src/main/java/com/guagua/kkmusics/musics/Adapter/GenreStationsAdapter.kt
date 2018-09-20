package com.guagua.kkmusics.musics.Adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.content.Context
import android.view.View
import com.guagua.kkmusics.R
import com.guagua.kkmusics.model.domainObject.GenreStations
import kotlinx.android.synthetic.main.item_genre_stations.view.*

class GenreStationsAdapter(val colors: IntArray, playlist: GenreStations = GenreStations()) : RecyclerView.Adapter<GenreStationsAdapter.ViewHolder>() {

    private var dataset = playlist
    private lateinit var context: Context
    private var colorMap: HashMap<Int, Int> = hashMapOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // create a new view
        context = parent.context
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_genre_stations, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, i: Int) {
        holder.name.text = dataset.data[i].name
        val color = getRandomColor()
        if (colorMap[i] == null) colorMap[i] = color
        holder.name.setBackgroundColor(color)
    }

    override fun getItemCount(): Int {
        return dataset.data.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val name = view.item_genre_stations_name
    }

    fun setData(data: GenreStations){
        dataset = data
        notifyDataSetChanged()
    }

    fun getRandomColor() = colors[(Math.random()*colors.size).toInt()]
}

