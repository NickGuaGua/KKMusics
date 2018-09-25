package com.guagua.kkmusics.model.domainObject

import com.google.gson.annotations.SerializedName

class Charts{

    @SerializedName("data")
    var datas: Array<Data> = arrayOf()

    @SerializedName("paging")
    var paging: Paging = Paging()

    @SerializedName("summary")
    var summary: Summary = Summary()

    class Data{

        @SerializedName("id")
        var id: String = ""

        @SerializedName("name")
        var name: String = ""

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

    }

}