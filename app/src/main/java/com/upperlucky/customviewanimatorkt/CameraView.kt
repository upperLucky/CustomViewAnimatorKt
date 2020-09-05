package com.upperlucky.customviewanimatorkt

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * created by yunKun.wen on 2020/9/3
 * desc:
 */
val BITMAP_PADDING = 100.dp
val BITMAP_WIDTH = 200.dp

class CameraView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path().apply {
        addOval(
            BITMAP_PADDING,
            BITMAP_PADDING,
            BITMAP_PADDING + BITMAP_WIDTH,
            BITMAP_PADDING + BITMAP_WIDTH,
            Path.Direction.CW
        )
    }

    var topFlip = 0f
        set(value) {
            field = value
            invalidate()
        }
    var bottomFlip = 30f
        set(value) {
            field = value
            invalidate()
        }
    var flipRotation = 0f
        set(value) {
            field = value
            invalidate()
        }
    private val camera = Camera()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

//        canvas.clipPath(path)

        // 上面部分
        canvas.save()
        canvas.translate(
            (BITMAP_PADDING + BITMAP_WIDTH / 2),
            (BITMAP_PADDING + BITMAP_WIDTH / 2)
        )
        canvas.rotate(-flipRotation)
        camera.save()
        camera.rotateX(topFlip)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.clipRect(-BITMAP_PADDING * 2, -BITMAP_WIDTH, BITMAP_WIDTH, 0f )
        canvas.rotate(flipRotation)
        canvas.translate(
            -(BITMAP_PADDING + BITMAP_WIDTH / 2),
            -(BITMAP_PADDING + BITMAP_WIDTH / 2)
        )
        canvas.drawBitmap(getAvator((BITMAP_WIDTH.toInt())), BITMAP_PADDING, BITMAP_PADDING, paint)
        canvas.restore()

        // 下面部分
        canvas.save()
        canvas.translate(
            (BITMAP_PADDING + BITMAP_WIDTH / 2),
            (BITMAP_PADDING + BITMAP_WIDTH / 2)
        )
        canvas.rotate(-flipRotation)
        camera.save()
        camera.rotateX(bottomFlip)
        camera.applyToCanvas(canvas)
        camera.restore()
        canvas.clipRect(-BITMAP_PADDING * 2, 0f, BITMAP_WIDTH, BITMAP_WIDTH)
        canvas.rotate(flipRotation)
        canvas.translate(
            -(BITMAP_PADDING + BITMAP_WIDTH / 2),
            -(BITMAP_PADDING + BITMAP_WIDTH / 2)
        )
        canvas.drawBitmap(getAvator((BITMAP_WIDTH.toInt())), BITMAP_PADDING, BITMAP_PADDING, paint)
        canvas.restore()
    }

    fun getAvator(width: Int): Bitmap {
        var options = BitmapFactory.Options()
        options.inJustDecodeBounds = true
        BitmapFactory.decodeResource(resources, R.drawable.icon, options)
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width
        return BitmapFactory.decodeResource(resources, R.drawable.icon, options)
    }
}