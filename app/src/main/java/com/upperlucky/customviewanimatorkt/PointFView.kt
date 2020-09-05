package com.upperlucky.customviewanimatorkt

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.util.AttributeSet
import android.view.View

/**
 * created by yunKun.wen on 2020/9/4
 * desc:
 */
class PointFView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 20.dp
        strokeCap = Paint.Cap.ROUND
    }

    var point = PointF(0f, 0f)
        set(value) {
            field = value
            invalidate()
        }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawPoint(point.x, point.y, paint)
    }
}