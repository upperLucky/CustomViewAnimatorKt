package com.upperlucky.customviewanimatorkt

import android.animation.*
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        /*val animator = ObjectAnimator.ofFloat(view, "radius", 50.dp, 150.dp)
        animator.startDelay = 1000
        animator.start()*/


        /*val animator = ObjectAnimator.ofObject(view, "point", object : TypeEvaluator<PointF> {
            override fun evaluate(fraction: Float, startValue: PointF, endValue: PointF): PointF {
                var startX = startValue.x
                var endX = endValue.x
                var currentX = startX + (endX - startX) * fraction

                var startY = startValue.y
                var endY = endValue.y
                var currentY = startY + (endY - startY) * fraction
                return PointF(currentX, currentY)
            }

        }, PointF(100.dp, 200.dp))
        animator.startDelay = 1000
        animator.duration = 2000
        animator.start()*/

        /*val bottomFlipAnimator = ObjectAnimator.ofFloat(view, "bottomFlip", 60f)
        bottomFlipAnimator.duration = 1000

        val flipRotationAnimator = ObjectAnimator.ofFloat(view, "flipRotation", 270f)
        flipRotationAnimator.duration = 1000

        val topFlipAnimator = ObjectAnimator.ofFloat(view, "topFlip", -60f)
        topFlipAnimator.duration = 1000

        val animatorSet = AnimatorSet()
        animatorSet.playSequentially(bottomFlipAnimator, flipRotationAnimator, topFlipAnimator)
        animatorSet.startDelay = 1000
        animatorSet.start()*/


        /*val bottomFlipHolder = PropertyValuesHolder.ofFloat("bottomFlip", 60f)
        val flipRotationFlipHolder = PropertyValuesHolder.ofFloat("flipRotation", 270f)
        val topFlipHolder = PropertyValuesHolder.ofFloat("topFlip", -60f)

        val animator = ObjectAnimator.ofPropertyValuesHolder(view,
            bottomFlipHolder,
            flipRotationFlipHolder,
            topFlipHolder
        )
        animator.startDelay = 1000
        animator.duration = 2000
        animator.start()*/

        val animator = ObjectAnimator.ofObject(
            view, "province",
            ProvinceEvaluator(), "澳门特别行政区")
        animator.startDelay = 1000
        animator.duration = 5000
        animator.start()

    }
}