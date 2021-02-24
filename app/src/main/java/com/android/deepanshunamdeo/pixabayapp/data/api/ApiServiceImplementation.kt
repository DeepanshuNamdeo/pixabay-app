package com.android.deepanshunamdeo.pixabayapp.data.api

import com.android.deepanshunamdeo.pixabayapp.data.model.PictureDetail
import retrofit2.Call
import javax.inject.Inject

class ApiServiceImplementation @Inject constructor(private val apiService: ApiService) {

    fun getPictureDetails(): Call<PictureDetail> = apiService.getPicsDetails()
}