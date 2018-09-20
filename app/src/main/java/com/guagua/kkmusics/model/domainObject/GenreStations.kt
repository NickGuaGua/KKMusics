package com.guagua.kkmusics.model.domainObject

import com.google.gson.annotations.SerializedName

class GenreStations{

    @SerializedName("data")
    var data: Array<Data> = arrayOf()

    @SerializedName("paging")
    var paging: Paging = Paging()

    @SerializedName("summary")
    var summary: Summary = Summary()

    class Data{

        @SerializedName("id")
        var id: String = ""

        @SerializedName("category")
        var category: String = ""

        @SerializedName("name")
        var name: String = ""
    }

}