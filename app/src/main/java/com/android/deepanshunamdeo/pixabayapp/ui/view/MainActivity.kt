package com.android.deepanshunamdeo.pixabayapp.ui.view

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import com.android.deepanshunamdeo.pixabayapp.R
import com.android.deepanshunamdeo.pixabayapp.data.model.Hits
import com.android.deepanshunamdeo.pixabayapp.ui.adapter.PictureViewAdapter
import com.android.deepanshunamdeo.pixabayapp.ui.adapter.PictureViewOnClickListener
import com.android.deepanshunamdeo.pixabayapp.ui.viewmodel.PictureDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), PictureViewOnClickListener {
    private lateinit var adapter: PictureViewAdapter
    private val picDetailViewModel: PictureDetailsViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView_picture_preview.layoutManager = GridLayoutManager(this, 2)
        } else {
            recyclerView_picture_preview.layoutManager = GridLayoutManager(this, 4)
        }
        adapter = PictureViewAdapter(arrayListOf(), this)
        recyclerView_picture_preview.addItemDecoration(
            DividerItemDecoration(
                recyclerView_picture_preview.context,
                (recyclerView_picture_preview.layoutManager as GridLayoutManager).orientation
            )
        )
        recyclerView_picture_preview.adapter = adapter
    }

    private fun setupObserver() {
        picDetailViewModel.getPictureDetail.observe(this, Observer {
            /*  this.progressBar_loading.visibility= View.GONE
            this.recyclerView_pic_details.visibility= View.VISIBLE*/
            renderList(it.hits)
        })
    }

    private fun renderList(picture: List<Hits>) {
        adapter.addData(picture)
        adapter.notifyDataSetChanged()
    }

    override fun onClickPicture(hits: Hits) {
        val intent = Intent(this, PictureViewActivity::class.java)
        intent.putExtra("webformatURL", hits.webformatURL)
        startActivity(intent)
    }


}