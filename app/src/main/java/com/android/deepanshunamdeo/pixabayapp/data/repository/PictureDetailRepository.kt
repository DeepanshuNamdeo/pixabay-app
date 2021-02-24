package com.android.deepanshunamdeo.pixabayapp.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.android.deepanshunamdeo.pixabayapp.data.api.ApiServiceImplementation
import com.android.deepanshunamdeo.pixabayapp.data.model.PictureDetail
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class PictureDetailRepository @Inject constructor(private val apiService: ApiServiceImplementation) {
    var pictureDetail = MutableLiveData<PictureDetail>()

    fun getPictureDetails(): MutableLiveData<PictureDetail> {
        val call = apiService.getPictureDetails()
        call.enqueue(object : Callback<PictureDetail> {
            override fun onResponse(call: Call<PictureDetail>, response: Response<PictureDetail>) {

                val data = response.body()
                pictureDetail.value = PictureDetail(data!!.total, data!!.totalHits, data!!.hits)
            }

            override fun onFailure(call: Call<PictureDetail>, t: Throwable) {
                Log.v("DEBUG : ", t.message.toString())

            }

        })
        return pictureDetail
    }

}