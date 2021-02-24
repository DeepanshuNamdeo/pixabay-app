package com.android.deepanshunamdeo.pixabayapp.data.api

import com.android.deepanshunamdeo.pixabayapp.data.model.PictureDetail
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    //base url - https://pixabay.com/api/
    @GET("?key=20383650-e9a2817d8bd712e501234435e&q=yellow+flowers&image_type=photo&pretty=true")
    fun getPicsDetails(): Call<PictureDetail>
}