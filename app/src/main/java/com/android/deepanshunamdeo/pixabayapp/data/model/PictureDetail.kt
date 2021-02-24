package com.android.deepanshunamdeo.pixabayapp.data.model

data class PictureDetail(
    val total: Int,
    val totalHits: Int,
    val hits: ArrayList<Hits>
) {
}

data class Hits(
    val previewURL: String,
    val webformatURL: String
) {

}
