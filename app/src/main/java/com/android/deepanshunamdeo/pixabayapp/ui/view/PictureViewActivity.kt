package com.android.deepanshunamdeo.pixabayapp.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.deepanshunamdeo.pixabayapp.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_picture_view.*


class PictureViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picture_view)
        val animPlaceholder =
            Glide.with(imageView_picture.context).load(intent.getStringExtra("webformatURL"))
                .thumbnail(Glide.with(this).load(R.raw.loading)).into(
                    imageView_picture
                );

    }
}