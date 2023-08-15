package com.example.anonymous_store_sprint6.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CellRetroFit {
    companion object{

        private const val BASE_URL = "https://my-json-server.typicode.com/Himuravidal/FakeAPIdata/"

        fun gedRetroFitCell(): CallApi{

            val mRetrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return mRetrofit.create(CallApi::class.java)

        }


    }
}