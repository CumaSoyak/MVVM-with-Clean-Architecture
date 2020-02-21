package com.util.extensions

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

fun ImageView.load(@DrawableRes resourceId: Int) {
    Glide.with(context).load(resourceId)
        .into(this)
}

fun ImageView.load(url: String?) {
    Glide.with(context).load(url)
        .into(this)
}