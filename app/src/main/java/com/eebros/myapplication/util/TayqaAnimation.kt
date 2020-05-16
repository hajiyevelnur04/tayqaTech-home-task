package com.eebros.myapplication.util

import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

object TayqaAnimation {
    //animation for recyclerView
    fun animateProgressImage(recyclerViewContainer: RecyclerView, imageView: ImageView) {
        recyclerViewContainer.visibility = View.GONE
        imageView.visibility = View.VISIBLE
        val rotate = RotateAnimation(0f,
            360f,
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )
        rotate.duration = 3000
        rotate.interpolator = LinearInterpolator()
        rotate.repeatCount = Animation.INFINITE

        imageView.startAnimation(rotate)
    }
}
