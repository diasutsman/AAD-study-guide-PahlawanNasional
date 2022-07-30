package com.example.pahlawannasional.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.pahlawannasional.R

object BindingAdapters {

    @BindingAdapter("android:imageUrl")
    @JvmStatic
    fun imageUrl(imageView: ImageView, url: String) {
        Glide.with(imageView)
            .load(url)
            .placeholder(R.drawable.ic_broken_image)
            .error(R.drawable.ic_broken_image)
            .into(imageView)
    }

}