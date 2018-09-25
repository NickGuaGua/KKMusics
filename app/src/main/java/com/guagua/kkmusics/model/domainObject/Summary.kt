package com.guagua.kkmusics.model.domainObject

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Summary: Serializable {

    @SerializedName("total")
    var total: Int = 0
}