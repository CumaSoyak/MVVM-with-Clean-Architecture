package com.util.extensions

import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.remote.model.image.Image


fun ConstraintLayout.ratio(viewId: Int, image: Image?) {
    val set = ConstraintSet()
    val ratio = String.format("%d:%d", image?.width, image?.height)
    set.clone(this)
    set.setDimensionRatio(viewId, ratio)
    set.applyTo(this)
}