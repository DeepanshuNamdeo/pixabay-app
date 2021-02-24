package com.android.deepanshunamdeo.pixabayapp.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.android.deepanshunamdeo.pixabayapp.data.model.PictureDetail
import com.android.deepanshunamdeo.pixabayapp.data.repository.PictureDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PictureDetailsViewModel @Inject constructor(private val pictureDetailRepository: PictureDetailRepository) :
    ViewModel() {

    val getPictureDetail: LiveData<PictureDetail> = pictureDetailRepository.getPictureDetails()


}