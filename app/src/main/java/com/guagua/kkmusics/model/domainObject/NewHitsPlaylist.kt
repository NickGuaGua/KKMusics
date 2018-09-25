package com.guagua.kkmusics.model.domainObject

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class NewHitsPlaylist: Serializable {

    @SerializedName("tracks")
    var tracks: Track = Track()

    @SerializedName("id")
    var id: String = ""

    @SerializedName("title")
    var title: String = ""

    @SerializedName("description")
    var description: String = ""

    @SerializedName("url")
    var url: String = ""

    @SerializedName("images")
    var images: Array<Image> = arrayOf()

    @SerializedName("updated_at")
    var updatedAt: String = ""

    @SerializedName("owner")
    var owner: Owner = Owner()

    class Track: Serializable{

        @SerializedName("data")
        var datas: Array<Data> = arrayOf()

        @SerializedName("paging")
        var paging: Paging = Paging()

        @SerializedName("summary")
        var summary: Summary = Summary()
    }

    class Data: Serializable{

        @SerializedName("id")
        var id: String = ""

        @SerializedName("name")
        var name: String = ""

        @SerializedName("duration")
        var duration: Int = 0

        @SerializedName("url")
        var url: String = ""

        @SerializedName("track_number")
        var trackNumber: Int = 1

        @SerializedName("explicitness")
        var explicitness: Boolean = false

        @SerializedName("available_territories")
        var availableTerritories: Array<String> = arrayOf()

        @SerializedName("album")
        var album: Album = Album()

    }

    class Album: Serializable{

        @SerializedName("id")
        var id: String = ""

        @SerializedName("name")
        var name: String = ""

        @SerializedName("url")
        var url: String = ""

        @SerializedName("explicitness")
        var explicitness: Boolean = false

        @SerializedName("available_territories")
        var availableTerritories: Array<String> = arrayOf()

        @SerializedName("releaseDate")
        var releaseDate: String = ""

        @SerializedName("images")
        var images: Array<Image> = arrayOf()

        @SerializedName("artist")
        var artist: Artist = Artist()

    }

    class Artist: Serializable{

        @SerializedName("id")
        var id: String = ""

        @SerializedName("name")
        var name: String = ""

        @SerializedName("url")
        var url: String = ""

        @SerializedName("images")
        var images: Array<Image> = arrayOf()
    }
}