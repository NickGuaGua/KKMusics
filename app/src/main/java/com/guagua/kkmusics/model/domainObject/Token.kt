package com.guagua.kkmusics.model.domainObject

import com.google.gson.annotations.SerializedName

class Token{

    @SerializedName("access_token")
    var accessToken: String = ""

    @SerializedName("expires_in")
    var expiresIn: Int = 0

    @SerializedName("token_type")
    var tokenType: String = ""

}