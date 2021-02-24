package com.android.deepanshunamdeo.pixabayapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.android.deepanshunamdeo.pixabayapp.R
import com.android.deepanshunamdeo.pixabayapp.data.model.Hits
import com.bumptech.glide.Glide

class PictureViewAdapter(
    private val pictureItemList: ArrayList<Hits>,
    val listener: PictureViewOnClickListener
) : RecyclerView.Adapter<PictureViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val pictureViewHolder = PictureViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.picture_grid_item_layout, parent, false)
        )

        pictureViewHolder.imageView_picture.setOnClickListener {
            listener.onClickPicture(pictureItemList[pictureViewHolder.adapterPosition])
        }
        return pictureViewHolder
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        val currentItem = pictureItemList[position]

        Glide.with(holder.imageView_picture.context).load(currentItem.previewURL)
            .into(holder.imageView_picture);

    }

    override fun getItemCount(): Int = pictureItemList.size
    fun addData(picture: List<Hits>) {
        pictureItemList.addAll(picture)
        notifyDataSetChanged()
    }
}

class PictureViewHolder(item: View) : RecyclerView.ViewHolder(item) {
    val imageView_picture: ImageView = itemView.findViewById(R.id.imageView_picture)

}

interface PictureViewOnClickListener {
    fun onClickPicture(hits: Hits)
}