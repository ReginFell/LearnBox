package com.regin.learnbox.presentation.view

import android.graphics.drawable.GradientDrawable
import android.support.design.widget.CoordinatorLayout
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.view.View
import com.regin.learnbox.R


class MaterialSnackbar {

    companion object {
        fun make(view: View, text: String, duration: Int): Snackbar {
            return Snackbar.make(view, text, duration)
                    .also {
                        val color = ContextCompat.getColor(view.context, android.R.color.black)
                        val radius = view.context.resources.getDimensionPixelOffset(R.dimen.material_snackbar_radius)
                        val layoutParams = it.view.layoutParams as CoordinatorLayout.LayoutParams

                        val drawable = GradientDrawable()
                        drawable.setColor(color)
                        drawable.cornerRadius = radius.toFloat()

                        layoutParams.marginStart = radius
                        layoutParams.marginEnd = radius
                        layoutParams.topMargin = radius
                        layoutParams.bottomMargin = radius

                        it.view.background = drawable
                    }
        }
    }
}