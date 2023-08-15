package com.example.anonymous_store_sprint6.data.remote

import retrofit2.Response
import retrofit2.http.GET

interface CallApi {

    @GET("products/")
    suspend fun getDataCell(): Response<Cell>

}