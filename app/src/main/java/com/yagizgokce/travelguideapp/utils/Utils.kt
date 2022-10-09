package com.yagizgokce.travelguideapp.utils


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

fun ImageView.apiDownloadFromUrl(url : String?){

    url?.let {
        Glide.with(context)
            .load(url)
            .into(this)
    }
}

@BindingAdapter("android:downloadImage")
fun downloadImage(view: ImageView, url: String?) {
    view.apiDownloadFromUrl(url)
}