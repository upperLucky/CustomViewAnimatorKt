package com.upperlucky.customviewanimatorkt

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * created by yunKun.wen on 2020/9/4
 * desc:
 */

class CircleView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var radius = 50.dp
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawCircle(width.toFloat() / 2, height.toFloat() / 2, radius, paint)
    }
}