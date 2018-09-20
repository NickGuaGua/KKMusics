package com.guagua.kkmusics.model.musicModel

import com.guagua.kkmusics.model.domainObject.Token
import retrofit2.Call
import retrofit2.http.*

interface AuthApiService{

    @Headers("Content-Type:application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("/oauth2/token")
    fun getToken(@Header("Authorization") authHeader: String, @Field("grant_type") s: String = "client_credentials"): Call<Token>

}