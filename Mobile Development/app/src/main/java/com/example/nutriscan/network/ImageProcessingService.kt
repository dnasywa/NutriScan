package com.example.nutriscan.network

import okhttp3.Call
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ImageProcessingService {
    @Multipart
    @POST("process-image")
    fun processImage(@Part image: MultipartBody.Part): Call<YourResponseModel>
}