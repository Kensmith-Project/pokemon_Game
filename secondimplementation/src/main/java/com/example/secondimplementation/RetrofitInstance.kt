package com.example.secondimplementation

import com.example.secondimplementation.Client.ImageUploadClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private var retrofit: Retrofit? = null
    private val BASE_URL = "https://darot-image-upload-service.herokuapp.com/api/v1/"

    fun getRetrofit(): ImageUploadClient? {
        val okHttpClient = OkHttpClient.Builder().build()
        if (retrofit == null) {
            retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).client(okHttpClient).build()
        }
        return retrofit?.create(ImageUploadClient::class.java)
    }
}