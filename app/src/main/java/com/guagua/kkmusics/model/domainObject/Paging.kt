package com.guagua.kkmusics.model.domainObject

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Paging: Serializable {

    @SerializedName("offset")
    var offset: Int = 0

    @SerializedName("limit")
    var limit: Int = 0

    @SerializedName("previous")
    var previous: NewHitsPlaylists? = null

    @SerializedName("next")
    var next: NewHitsPlaylists? = null
}
