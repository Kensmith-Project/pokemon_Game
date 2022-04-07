package com.example.secondimplementation.Client


import com.example.secondimplementation.Module.ImageUploadResponse
import retrofit2.Call
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ImageUploadClient {
    @Multipart
    @POST("upload")
    fun uploadPhoto(
        @Part("image") description: String?
    ): Call<ImageUploadResponse?>?

}