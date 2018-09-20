package com.guagua.kkmusics.model.musicModel

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class APIBuilder <T>{

    private var service: Class<T>
    private var url: String
    private var client: OkHttpClient

    @Inject
    constructor(service: Class<T>, url: String, client: OkHttpClient = OkHttpClient()){
        this.service = service
        this.url = url
        this.client = client
    }

    fun build(): T = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .client(client)
            .build().create(service)

}