package com.guagua.kkmusics.model.domainObject

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Owner: Serializable {

    @SerializedName("id")
    var id: String = ""

    @SerializedName("name")
    var name: String = ""

    @SerializedName("description")
    var description: String = ""

    @SerializedName("images")
    var images: Array<Image> = arrayOf()

}